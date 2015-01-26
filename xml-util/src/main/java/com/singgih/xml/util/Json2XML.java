package com.singgih.xml.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class Json2XML {
	static Logger log = Logger.getLogger("com.singgih.xml");

	public XmlObject convertJsonToXMLObject(String tagName, String json) {
		String xmlString = convertJsonToXMLString(tagName, json);
		Document document = null;
		XmlObject xmlObject = null;
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			document = docBuilder.parse( new InputSource( new StringReader( xmlString ) ) );  
			xmlObject = XmlObject.Factory.parse(document);
		} catch (ParserConfigurationException fuckingException) {
			log.error("Fucking Exception : "+ fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}catch (IOException fuckingException) {
			log.error("Fucking Exception : "+ fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		catch (SAXException fuckingException) {
			log.error("Fucking Exception : "+ fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		catch (XmlException fuckingException) {
			log.error("Fucking Exception : "+ fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return xmlObject;
	}

	public String convertJsonToXMLString(String tagName, String json) {
		JSONObject jsonObject = new JSONObject(json);
		StringBuffer xmlString = new StringBuffer();
		xmlString.append("<" + tagName + ">");
		xmlString.append(XML.toString(jsonObject));
		xmlString.append("</" + tagName + ">");
		return xmlString.toString();
	}

	public String convertJsonFileToXMLString(String tagName, String path) {
		String jsonString = readFile(path);
		return convertJsonToXMLString(tagName, jsonString);
	}

	private String readFile(String path) {
		log.debug("Read file : " + path);
		String text = null;
		try {
			text = Files.toString(new File(path), Charsets.UTF_8);
		} catch (IOException fuckingException) {
			log.error("Fucking Exception : "
					+ fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return text;
	}
}
