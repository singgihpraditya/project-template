package com.singgih.properties.util;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class PropertiesUtil {
	static Logger log = Logger.getLogger("com.singgih.properties");

	private static Table<String, String, String> configuration = null;
	private static String configFileName;

	private static Table<String, String, String> getConfiguration(String latestFileName) {
		log.debug("Get configuration : " + latestFileName);
		configFileName = latestFileName;
		if (configuration == null) {
			log.debug("Configuration is null, create new table");
			configuration = HashBasedTable.create();
		}
		if (!configuration.containsRow(configFileName)) {
			log.debug("Configuration " + configFileName + " is empty, fill it");
			new PropertiesLoader().fillConfiguration(configFileName, configuration);
		}
		return configuration;
	}

	public static Map<String, Map<String, String>> getConfigurationAsMap(String latestFileName) {
		log.debug("Get configuration : " + latestFileName);
		configFileName = latestFileName;
		if (configuration == null) {
			log.debug("Configuration is null, create new table");
			configuration = HashBasedTable.create();
		}
		if (!configuration.containsRow(configFileName)) {
			log.debug("Configuration " + configFileName + " is empty, fill it");
			new PropertiesLoader().fillConfiguration(configFileName, configuration);
		}
		return configuration.columnMap();
	}

	public static void reload() {
		Stopwatch stopwatch = new Stopwatch().start();
		if (configuration != null) {
			configuration = HashBasedTable.create();
			log.debug("Reload configuration");
			for (String configFileName : configuration.columnKeySet()) {
				new PropertiesLoader().fillConfiguration(configFileName, configuration);
			}
		}
		log.debug("Method executed on " + (stopwatch.elapsed(TimeUnit.MICROSECONDS)) + " us");
	}

	public static String getStringPropertyFromFile(String latestFileName, String propertyKey) {
		return getPropertyFromFile(latestFileName, propertyKey);
	}

	public static String getStringPropertyFromFile(String latestFileName, String propertyKey, String defaultValue) {
		return getPropertyFromFile(latestFileName, propertyKey, defaultValue);
	}

	public static Integer getIntegerPropertyFromFile(String latestFileName, String propertyKey) {
		try {
			return Integer.parseInt(getPropertyFromFile(latestFileName, propertyKey));
		} catch (NumberFormatException fuckingException) {
			log.debug("Fucking exception : " + fuckingException);
			fuckingException.printStackTrace();
			return null;
		}
	}

	public static Integer getIntegerPropertyFromFile(String latestFileName, String propertyKey, String defaultValue) {
		try {
			return Integer.parseInt(getPropertyFromFile(latestFileName, propertyKey, defaultValue));
		} catch (NumberFormatException fuckingException) {
			log.debug("Fucking exception : " + fuckingException);
			fuckingException.printStackTrace();
			return null;
		}
	}

	public static Long getLongPropertyFromFile(String latestFileName, String propertyKey) {
		try {
			return Long.parseLong(getPropertyFromFile(latestFileName, propertyKey));
		} catch (NumberFormatException fuckingException) {
			log.debug("Fucking exception : " + fuckingException);
			fuckingException.printStackTrace();
			return null;
		}
	}

	public static Long getLongPropertyFromFile(String latestFileName, String propertyKey, String defaultValue) {
		try {
			return Long.parseLong(getPropertyFromFile(latestFileName, propertyKey, defaultValue));
		} catch (NumberFormatException fuckingException) {
			log.debug("Fucking exception : " + fuckingException);
			fuckingException.printStackTrace();
			return null;
		}
	}

	public static Double getDoublePropertyFromFile(String latestFileName, String propertyKey) {
		try {
			return Double.parseDouble(getPropertyFromFile(latestFileName, propertyKey));
		} catch (NumberFormatException fuckingException) {
			log.debug("Fucking exception : " + fuckingException);
			fuckingException.printStackTrace();
			return null;
		}
	}

	public static Double getDoublePropertyFromFile(String latestFileName, String propertyKey, String defaultValue) {
		try {
			return Double.parseDouble(getPropertyFromFile(latestFileName, propertyKey, defaultValue));
		} catch (NumberFormatException fuckingException) {
			log.debug("Fucking exception : " + fuckingException);
			fuckingException.printStackTrace();
			return null;
		}
	}

	public static Boolean getBooleanPropertyFromFile(String latestFileName, String propertyKey) {
		try {
			return new Boolean(getPropertyFromFile(latestFileName, propertyKey));
		} catch (Exception fuckingException) {
			log.debug("Fucking exception : " + fuckingException);
			fuckingException.printStackTrace();
			return null;
		}
	}

	public static Boolean getBooleanPropertyFromFile(String latestFileName, String propertyKey, String defaultValue) {
		try {
			return new Boolean(getPropertyFromFile(latestFileName, propertyKey, defaultValue));
		} catch (Exception fuckingException) {
			log.debug("Fucking exception : " + fuckingException);
			fuckingException.printStackTrace();
			return null;
		}
	}

	public static String getPropertyFromFile(String latestFileName, String propertyKey) {
		Stopwatch stopwatch = new Stopwatch().start();
		configuration = getConfiguration(latestFileName);
		String property = (String) configuration.get(latestFileName, propertyKey);
		log.debug("Method executed on : " + (stopwatch.elapsed(TimeUnit.MICROSECONDS)) + " us");
		return property;
	}

	public static String getPropertyFromFile(String latestFileName, String propertyKey, String defaultValue) {
		Stopwatch stopwatch = new Stopwatch().start();
		configuration = getConfiguration(latestFileName);
		String property = (String) configuration.get(latestFileName, propertyKey);
		if (property == null)
			property = defaultValue;
		log.debug("Method executed on : " + (stopwatch.elapsed(TimeUnit.MICROSECONDS)) + " us");
		return property;
	}
}
