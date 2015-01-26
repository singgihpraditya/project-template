package test.com.singgih.jsonpath.sample;

import org.junit.Test;

import com.singgih.lucene.sample.service.BookDbService;

public class TestInsertDB {
	@Test
	public void testInsert(){
		int size = 5000;
		BookDbService bookDbService = new BookDbService();
		bookDbService.createMockData(size);
	}
}
