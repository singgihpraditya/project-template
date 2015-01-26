package com.singgih.lucene.sample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;
import com.singgih.lucene.sample.model.Book;
import com.singgih.lucene.sample.util.ConnectionUtil;

public class BookDbService {
	Logger log = Logger.getLogger("com.singgih.lucene");

	private Stopwatch stopwatch = null;

	protected void startTimer() {
		stopwatch = new Stopwatch().start();
	}

	protected void stopTimer() {
		log.debug("Executed on : " + (stopwatch.elapsed(TimeUnit.MILLISECONDS))
				+ " ms");
	}
	
	public void createMockData(int size){
		for(int i=0; i<size; i++){
			log.debug("Inserting isbn"+i+", title_"+i);
			singleInsert(new Book(null,"isbn"+i,"title_"+i));
		}
		log.debug("Inserting "+size+" mock datas done ");
	}
	
	public void bulkInsert(List<Book> books){
		for (Book book : books) {
			singleInsert(book);
		}
		log.debug("Inserting bulk datas done ");
	}
	
	public void singleInsert(Book book){
		Connection connection =ConnectionUtil.getConnection();
		String sqlQuery = "insert into book(isbn, title) values(?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ConnectionUtil.closePreparedStatement(preparedStatement);
			ConnectionUtil.closeConnection(connection);
		}
	}
	
	public List<Book> search(String category, String keyword, Boolean match){
		startTimer();
		List<Book> books = new ArrayList<Book>();
		Connection connection =ConnectionUtil.getConnection();
		String sqlQuery = searchQueryBuilder(category, match);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		log.debug("Sql query : "+sqlQuery);
		try {
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, match ? keyword : "%" + keyword+ "%");
			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();
			while(resultSet.next()){
				books.add(new Book(null, resultSet.getString("isbn"), resultSet.getString("title")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ConnectionUtil.closeConnection(connection);
			ConnectionUtil.closePreparedStatement(preparedStatement);
		}
		stopTimer();
		log.debug("Found "+books.size()+" book(s)");
		return books;
	}
	
	public List<Book> getAllBooks(){
		startTimer();
		List<Book> books = new ArrayList<Book>();
		Connection connection =ConnectionUtil.getConnection();
		String sqlQuery = "select isbn, title from book";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		log.debug("Sql query : "+sqlQuery);
		try {
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();
			while(resultSet.next()){
				books.add(new Book(null,resultSet.getString("isbn"), resultSet.getString("title")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ConnectionUtil.closeConnection(connection);
			ConnectionUtil.closePreparedStatement(preparedStatement);
		}
		stopTimer();
		log.debug("Found "+books.size()+" book(s)");
		return books;
	}

	private String searchQueryBuilder(String category, Boolean match){
		StringBuffer strQueryBuffer = new StringBuffer();
		strQueryBuffer.append("select isbn, title from book");
		strQueryBuffer.append(" where "+category);
		
		if(match){
			strQueryBuffer.append(" = ?");
		}
		else{
			strQueryBuffer.append(" like ?");
		}
		
		return strQueryBuffer.toString();
	}
}
