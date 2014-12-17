package com.singgih.properties.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.google.common.collect.Table;

public class PropertiesLoader {
	static Logger log = Logger.getLogger("com.singgih.properties");

	public Table<String, String, String> fillConfiguration(String configFileName, Table<String, String, String> table) {
		Properties properties = new Properties();

		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream(configFileName));
			for (Object key : properties.keySet()) {
				table.put(configFileName, (String) key, properties.getProperty((String) key));
			}
		} catch (IOException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (NullPointerException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return table;
	}
}
