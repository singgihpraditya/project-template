package test.com.singgih.jsonpath.sample;

import org.junit.Test;

import com.singgih.lucene.sample.service.BookDbService;

public class TestSearchDB {
	@Test
	public void testSearch(){
		String keyword = "isbn";
		
		BookDbService bookDbService = new BookDbService();
		bookDbService.search("isbn", keyword, false);
	}
}
