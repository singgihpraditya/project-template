package test.com.singgih.jsonpath.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.Test;

import com.singgih.lucene.sample.model.Book;
import com.singgih.lucene.sample.service.BookLuceneService;

public class TestLucene {
	Logger log = Logger.getLogger("com.singgih.lucene");

	@Test
	public void testLucene() {
		BookLuceneService luceneService = new BookLuceneService();
		try {
//			luceneService.add(generateList());
//			printList(luceneService.search("isbn", "isbn1"));
//			printList(luceneService.search("isbn", "isbn12"));
//			printList(luceneService.search("isbn", "isbn123"));
//			printList(luceneService.search("title", "games of lord").getHits());
			printList(luceneService.search("title", "lord ring").getHits());
			printList(luceneService.search("title", "lord ring").getHits());
			
//			Book toUpdateBook = new Book("isbn1234", "foobar");
//			luceneService.update(toUpdateBook);
//			printList(luceneService.search("isbn", "isbn1234"));
			
//			List<Book> lists = luceneService.search("isbn", "isbn1234");
			
//			for (Book book : lists) {
//				log.debug("book isbn : "+book.getIsbn()+", title : "+book.getTitle());
//				book.setTitle("updated title");
//				luceneService.update(book);
//			}
//			lists = luceneService.search("isbn", "isbn1");
//			for (Book book : lists) {
//				log.debug("book isbn : "+book.getIsbn()+", title : "+book.getTitle());
//			}	
//			luceneService.remove(new Book("isbn1","foobar"));
			luceneService.closeIndex();
		} catch (IOException fuckingException) {
			log.debug("Fucking Exception : "+fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		catch (ParseException fuckingException) {
			log.debug("Fucking Exception : "+fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
	}
	
	private List<Book> generateList(){
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("12345678","ISBN12345678","Lord Of The Ring"));
		books.add(new Book("23456789","ISBN23456789","Lord Of War"));
		books.add(new Book("34567890","ISBN34567890","The Hobbit : Unexpected Journey"));
		books.add(new Book("34567892","ISBN34567892","The Hobbit : Desolation of Smaug"));
		books.add(new Book("45678901","ISBN45678901","The Hunger Games"));
		books.add(new Book("56789023","ISBN56789023","Ring On Fire"));
		
		return books;
	}
	
	private void printList(List<Book> books){
		for (Book book : books) {
			log.debug("book isbn : " + book.getIsbn() + ", title : "+ book.getTitle());
		}
	}
}

 