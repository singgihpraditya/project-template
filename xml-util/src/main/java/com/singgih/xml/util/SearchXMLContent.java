package com.singgih.xml.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SearchXMLContent {
	static Logger log = Logger.getLogger("com.singgih.xml");

	public XmlObject searchByXPath(XmlObject xmlInput, String xpath) {
		XmlObject xmlObject = null;
		Document documentInput = null;
		Document documentOutput;

		InputStream inputStream = null;
		try {
			inputStream = xmlInput.newInputStream();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);

			DocumentBuilder builder = factory.newDocumentBuilder();
			documentInput = builder.parse(inputStream);
			documentOutput = builder.newDocument();
			documentOutput = searchDocumentByXPath(documentInput, documentOutput, xpath);

			xmlObject = XmlObject.Factory.parse(documentOutput);
		} catch (ParserConfigurationException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (IOException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (SAXException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (XmlException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (Exception fuckingException) {
				log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
				fuckingException.printStackTrace();
			}
		}
		return xmlObject;
	}

	public String searchByXPath(String xmlString, String xpath) {
		log.debug("Find xml with xpath : " + xpath);
		String searchResult = "";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		Document documentInput;
		Document documentOutput;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			documentInput = builder.parse(new ByteArrayInputStream((xmlString).getBytes()));
			documentOutput = builder.newDocument();
			documentOutput = searchDocumentByXPath(documentInput, documentOutput, xpath);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(documentOutput);
			StringWriter writer = new StringWriter();
			StreamResult streamResult = new StreamResult(writer);
			transformer.transform(domSource, streamResult);

			searchResult = writer.toString();
		} catch (SAXException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (IOException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (ParserConfigurationException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (TransformerConfigurationException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (TransformerException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return searchResult;
	}

	private Document searchDocumentByXPath(Document documentInput, Document documentOutput, String xpath) {
		try {
			XPath xPath = XPathFactory.newInstance().newXPath();
			XPathExpression expr = xPath.compile(xpath);
			NodeList nodeListFound = (NodeList) expr.evaluate(documentInput, XPathConstants.NODESET);
			Element resultsElement = documentOutput.createElement("results");
			for (int i = 0; i < nodeListFound.getLength(); i++) {
				Node node = (Node) nodeListFound.item(i);
				Element resultElement = documentOutput.createElement("result");
				Node newNode = documentOutput.importNode(node, true);
				resultElement.appendChild(newNode);
				resultsElement.appendChild(resultElement);
			}
			documentOutput.appendChild(resultsElement);
		} catch (XPathExpressionException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return documentOutput;
	}
}
