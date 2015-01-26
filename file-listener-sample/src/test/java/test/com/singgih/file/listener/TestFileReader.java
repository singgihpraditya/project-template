package test.com.singgih.file.listener;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.singgih.file.listener.FileReader;

public class TestFileReader {

	Logger log = Logger.getLogger("com.singgih.file.listener");
	@Test
	public void testSingletonService(){
		FileReader fileReader = new FileReader();
		String text = fileReader.readFile("C:/setup.log");
		log.debug("File content : "+text);
	}
}
