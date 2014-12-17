package test.com.singgih.xml.util;

import org.junit.Test;

import com.singgih.xml.util.SearchXMLContent;

public class TestSearchXMLContent {
	@Test
	public void testParseData() {
		String xmlString = "<foobar>"
				+ "<record>"
				+ "<foo>contentfoo1</foo>"
				+ "<bar>contentbar1</bar>"
				+ "</record>"
				+ "<record>"
				+ "<foo>contentfoo2</foo>"
				+ "<bar>contentbar2</bar>"
				+ "</record>"
				+ "</foobar>";
		String xpath = "//record[foo='contentfoo1']/bar/text()";
		String result = new SearchXMLContent().searchByXPath(xmlString, xpath);
		System.out.println(xmlString);
		System.out.println(result);
	}

}
