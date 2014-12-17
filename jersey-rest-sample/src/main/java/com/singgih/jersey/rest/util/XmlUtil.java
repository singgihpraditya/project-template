package com.singgih.jersey.rest.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

public class XmlUtil {
	Logger log = Logger.getLogger("com.singgih.jersey.rest");

	public String toXml(Object object) {
		JAXBContext jaxbContext;
		String xmlString = "";
		try {
			jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			jaxbMarshaller.marshal(object, stringWriter);
			xmlString = stringWriter.toString();
		} catch (JAXBException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return xmlString;
	}

	public Object toObject(String xml, Class clazz) {
		JAXBContext jaxbContext;
		Object object = null;
		try {
			jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
			object = jaxbUnmarshaller.unmarshal(inputStream);
			inputStream.close();
		} catch (JAXBException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (IOException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return object;
	}
}
