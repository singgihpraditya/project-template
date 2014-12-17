package test.com.singgih.xml.util;

import org.junit.Test;

import com.singgih.xml.util.ReplaceXMLContent;

public class TestUpdateXMLContent {
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
		String xpath = "//foo"; // "//record[foo='contentfoo1']/bar/text()";
		String newContent = "contentbar3";
		String result = new ReplaceXMLContent().replaceByXPath(xmlString, xpath, newContent);
		System.out.println(xmlString);
		System.out.println(result);
	}

}
