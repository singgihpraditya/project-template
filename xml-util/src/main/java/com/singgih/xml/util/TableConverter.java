package com.singgih.xml.util;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.common.collect.Table;

public class TableConverter<R extends Object, C extends Object, V extends Object> {
	static Logger log = Logger.getLogger("com.singgih.xml");

	public String convertTableToXMLString(String configTag, Table<R, C, V> table) {
		StringBuffer output = new StringBuffer();
		try {
			Document doc = getTableToXMLObjectDoc(configTag, table);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult streamResult = new StreamResult(writer);
			transformer.transform(domSource, streamResult);
			output.append(writer.toString());
		} catch (Exception fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return output.toString();
	}

	public XmlObject convertTableToXMLObject(String configTag, Table<R, C, V> table) {
		Document document = null;
		XmlObject xmlObject = null;
		try {
			document = getTableToXMLObjectDoc(configTag, table);
			xmlObject = XmlObject.Factory.parse(document);
		} catch (XmlException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return xmlObject;
	}

	private Document getTableToXMLObjectDoc(String configTag, Table<R, C, V> table) {
		Document document = null;
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			document = docBuilder.newDocument();
			Element rootElement = document.createElement(configTag);
			for (R object : table.rowKeySet()) {
				Element rowElement = document.createElement("row");
				Map<C, V> map = table.row(object);

				for (Object column : map.keySet()) {
					Element columnElement = document.createElement("column");
					Element nameElement = document.createElement("name");
					nameElement.appendChild(document.createTextNode(column.toString()));

					columnElement.appendChild(nameElement);
					Element valueElement = document.createElement("value");
					valueElement.appendChild(document.createTextNode(map.get(column).toString()));

					columnElement.appendChild(valueElement);
					rowElement.appendChild(columnElement);
				}
				rootElement.appendChild(rowElement);
			}
			document.appendChild(rootElement);
		} catch (ParserConfigurationException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return document;
	}
}
