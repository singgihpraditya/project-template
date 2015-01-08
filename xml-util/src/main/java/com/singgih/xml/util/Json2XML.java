package com.singgih.xml.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class Json2XML {
	static Logger log = Logger.getLogger("com.singgih.xml");

	public String convertJsonToXMLString(String tagName, String json) {
		JSONObject jsonObject = new JSONObject(json);
		StringBuffer xmlString = new StringBuffer();
		xmlString.append("<"+tagName+">");
		xmlString.append(XML.toString(jsonObject));
		xmlString.append("</"+tagName+">");
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
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return text;
	}
}
