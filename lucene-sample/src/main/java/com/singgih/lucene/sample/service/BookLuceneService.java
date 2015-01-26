package com.singgih.lucene.sample.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopScoreDocCollector;

import com.singgih.lucene.sample.model.Book;
import com.singgih.lucene.sample.model.Result;
import com.singgih.lucene.sample.util.Constants;

public class BookLuceneService extends BaseLuceneService<Book>{
	Logger log = Logger.getLogger("com.singgih.lucene");
	
	public void add(List<Book> books) throws IOException {
		startTimer();
		IndexWriter indexWriter = getIndexWriter();
		for (Book book : books) {
			addDoc(indexWriter, book);
		}
		indexWriter.commit();
		closeIndexWriter(indexWriter);
		stopTimer();
	}

	public void add(Book book) throws IOException {
		startTimer();
		IndexWriter indexWriter = getIndexWriter();
		addDoc(indexWriter, book);
		indexWriter.commit();
		closeIndexWriter(indexWriter);
		stopTimer();
	}

	public void update(Book book) throws IOException {
		startTimer();
		IndexWriter indexWriter = getIndexWriter();
		updateDoc(indexWriter, book);
		indexWriter.commit();
		indexWriter.close();
		stopTimer();
	}
	
	public void remove(Book book) throws IOException {
		startTimer();
		IndexWriter indexWriter = getIndexWriter();
		removeDoc(indexWriter, book);
		indexWriter.commit();
		indexWriter.close();
		stopTimer();
	}
	
	public Result<Book> search(String category, String keyword) throws IOException, ParseException {
		startTimer();
		Result<Book> result = new Result<Book>();
	
		List<Book> books = new ArrayList<Book>();
		IndexSearcher searcher = getIndexSearcher();
		int hitsPerPage = 10;

		TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
		StandardAnalyzer analyzer = new StandardAnalyzer(Constants.LUCENE_VERSION);;
		Query query = new TermQuery(new Term(category, keyword));
		searcher.search(query, collector);
		
		int totalHits =  collector.getTotalHits() ;
		boolean match = false;
		
		if(totalHits > 0){
			match = true;
			log.debug("Found " + totalHits + " record(s), with query : "+query.toString());
		}
		else {
			query = new QueryParser(Constants.LUCENE_VERSION, category, analyzer).parse(keyword);
			searcher.search(query, collector);
			totalHits =  collector.getTotalHits() ;
			log.debug("Found " + totalHits + " similar record(s), with query : "+query.toString());
		}	
		
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		
		for (int i = 0; i < hits.length; ++i) {
			int docId = hits[i].doc;
			Document document = searcher.doc(docId);
			Book book = new Book(document.get("indexId"),document.get("isbn"), document.get("title"));
			books.add(book);
		}
		
		closeIndexSearcher(searcher);
		
		long elapsedTime = stopTimer();

		result.setTotalHits(totalHits);
		result.setHits(books);
		result.setMatch(match);
		result.setElapsedTime(elapsedTime);
		result.setSearchDate(new Date());
		
		return result;
	}
	
	private void addDoc(IndexWriter indexWriter, Book book) throws IOException {
		log.debug("Add to index : "+book);
		Document doc = new Document();
		doc.add(new TextField("title", book.getTitle(), Field.Store.YES));
		doc.add(new StringField("isbn", book.getIsbn(), Field.Store.YES));
		doc.add(new StringField("indexId", book.getIndexId(), Field.Store.YES));
		indexWriter.addDocument(doc);
	}
	
	private void updateDoc(IndexWriter indexWriter, Book book) throws IOException {
		log.debug("Update to index : "+book);
		Document doc = new Document();
		doc.add(new TextField("title", book.getTitle(), Field.Store.YES));
		doc.add(new StringField("isbn", book.getIsbn(), Field.Store.YES));
		doc.add(new StringField("indexId", book.getIndexId(), Field.Store.YES));
		indexWriter.updateDocument(new Term("indexId", book.getIndexId()), doc);;
	}
	
	private void removeDoc(IndexWriter indexWriter, Book book) throws IOException {
		log.debug("Remove from index : "+book);
		indexWriter.deleteDocuments(new Term("indexId", book.getIndexId()));
	}
	
}