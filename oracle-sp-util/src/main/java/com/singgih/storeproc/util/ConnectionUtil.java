package com.singgih.storeproc.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.singgih.properties.util.PropertiesUtil;

public class ConnectionUtil {
	static Logger log = Logger.getLogger("com.singgih.storeproc");

	private static Connection connection;
	private static String configFileName = "oracle-sp.properties";

	public static Connection getConnection() {
		boolean usingDataSource = PropertiesUtil.getBooleanPropertyFromFile(configFileName, "using.datasource", "false");
		try {
			if (connection == null || connection.isClosed()) {
				if (usingDataSource) {
					log.debug("Get new connection using data source");
					return getDataSourceConnection();
				} else {
					log.debug("Get new connection using jdbc");
					return getJDBCConnection();
				}
			}
		} catch (SQLException fuckingException) {
			log.error("Fucking exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (ClassNotFoundException fuckingException) {
			log.error("Fucking exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (NamingException fuckingException) {
			log.error("Fucking exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return connection;
	}

	public static void closeCallableStatement(CallableStatement statement) {
		try {
			if (statement != null) {
				statement.close();
				log.debug("Statement is closed");
			}
		} catch (SQLException fuckingException) {
			log.error("Fucking exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
				log.debug("Result Set is closed");
			}
		} catch (SQLException fuckingException) {
			log.error("Fucking exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				log.debug("Connection is closed");
			}
		} catch (SQLException fuckingException) {
			log.error("Fucking exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
	}

	private static Connection getDataSourceConnection() throws SQLException, NamingException {
		InitialContext initialcontext = new InitialContext();
		String dataSourceName = PropertiesUtil.getStringPropertyFromFile(configFileName, "datasource.name");
		log.debug("Get connection to database with datasource : " + dataSourceName);
		DataSource datasource = (DataSource) initialcontext.lookup(dataSourceName);
		connection = datasource.getConnection();
		return connection;
	}

	private static Connection getJDBCConnection() throws SQLException, ClassNotFoundException, NullPointerException {
		String className = PropertiesUtil.getStringPropertyFromFile(configFileName, "jdbc.class.name");
		String url = PropertiesUtil.getStringPropertyFromFile(configFileName, "jdbc.url");
		String userName = PropertiesUtil.getStringPropertyFromFile(configFileName, "jdbc.user.name");
		String password = PropertiesUtil.getStringPropertyFromFile(configFileName, "jdbc.password");

		log.debug("Get connection to database with className : " + className + ", url : " + url + ", userName" + userName);

		Class.forName(className);
		connection = DriverManager.getConnection(url, userName, password);
		return connection;
	}
}
