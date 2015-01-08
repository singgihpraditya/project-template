package test.com.singgih.xml.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.singgih.xml.util.Json2XML;

public class TestJson2Xml {
	Logger log = Logger.getLogger("com.singgih.xml");

	@Test
	public void testParseJson() {
		String path = "e:/json.txt";
		Json2XML json2xml = new Json2XML();
		String xmlString = json2xml.convertJsonFileToXMLString("config",path);
		log.debug("json string : "+xmlString);
	}
}
