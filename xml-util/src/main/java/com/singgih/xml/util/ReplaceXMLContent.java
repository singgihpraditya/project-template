package com.singgih.xml.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReplaceXMLContent {
	static Logger log = Logger.getLogger("com.singgih.xml");

	public XmlObject replaceByXPath(XmlObject xmlInput, String xpath, String newContent) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put(xpath, newContent);
		return replaceByXPath(xmlInput, parameter);
	}

	public XmlObject replaceByXPath(XmlObject xmlInput, Map<String, String> parameter) {
		XmlObject xmlObject = null;
		Document documentInput = null;
		InputStream inputStream = null;
		try {
			inputStream = xmlInput.newInputStream();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);

			DocumentBuilder builder = factory.newDocumentBuilder();
			documentInput = builder.parse(inputStream);
			documentInput = replaceDocumentByXPath(documentInput, parameter);

			xmlObject = XmlObject.Factory.parse(documentInput);
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

	public String replaceByXPath(String xmlString, String xpath, String newContent) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put(xpath, newContent);
		return replaceByXPath(xmlString, parameter);
	}

	public String replaceByXPath(String xmlString, Map<String, String> parameter) {
		String searchResult = "";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		Document documentInput;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			documentInput = builder.parse(new ByteArrayInputStream((xmlString).getBytes()));
			documentInput = replaceDocumentByXPath(documentInput, parameter);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(documentInput);
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

	private Document replaceDocumentByXPath(Document documentInput, Map<String, String> parameter) {
		try {
			XPath xPath = XPathFactory.newInstance().newXPath();
			for (String xpath : parameter.keySet()) {
				XPathExpression expr = xPath.compile(xpath);
				NodeList nodeListFound = (NodeList) expr.evaluate(documentInput, XPathConstants.NODESET);
				log.info("Xpath : " + xpath);
				log.info("Found : " + nodeListFound.getLength() + " node(s)");
				for (int i = 0; i < nodeListFound.getLength(); i++) {
					Node nodeFound = (Node) nodeListFound.item(i);
					Node replaceNode = nodeFound.cloneNode(true);
					replaceNode.setTextContent(parameter.get(xpath));
					Node parentNode = nodeFound.getParentNode();
					parentNode.replaceChild(replaceNode, nodeFound);
				}
			}
		} catch (XPathExpressionException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return documentInput;
	}
}
