package com.singgih.storeproc.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import oracle.jdbc.OracleCallableStatement;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class StoreProcUtil {
	Logger log = Logger.getLogger("com.singgih.storeproc");

	public Map<Integer, Map<String, String>> executeStoreProcedureMap(String storeProcedureName, Map<String, Object> parameters) {
		return executeStoreProcedure(storeProcedureName, parameters).rowMap();
	}

	public Table<Integer, String, String> executeStoreProcedure(String storeProcedureName, Map<String, Object> parameters) {
		Stopwatch stopwatch = new Stopwatch().start();

		Table<Integer, String, String> data = HashBasedTable.create();

		Connection connection = ConnectionUtil.getConnection();
		log.debug("Execute procedure : " + storeProcedureName);
		String spQuery = constructStoreProcQuery(storeProcedureName, parameters.size());
		log.debug("Query : " + spQuery);
		try {
			CallableStatement callableStatement = connection.prepareCall(spQuery);
			int paramNo = 1;
			for (String key : parameters.keySet()) {
				Object object = parameters.get(key);
				if (object instanceof String) {
					callableStatement.setString(paramNo, (String) object);
					log.debug("Set param no: " + paramNo + ", field : " + key + ", value : " + object);
				}
				paramNo += 1;
			}
			log.debug("Registered cursor in : " + (parameters.size() + 1));
			callableStatement.registerOutParameter(parameters.size() + 1, oracle.jdbc.OracleTypes.CURSOR);
			callableStatement.execute();
			connection.commit();
			ResultSet resultSet = ((OracleCallableStatement) callableStatement).getCursor(parameters.size() + 1);
			int row = 0;
			while (resultSet.next()) {
				int columnCount = resultSet.getMetaData().getColumnCount();
				log.debug("Column count : " + columnCount);
				for (int i = 1; i <= columnCount; i++) {
					String value = resultSet.getString(i) == null ? "" : resultSet.getString(i);
					data.put(row, resultSet.getMetaData().getColumnLabel(i), value);
				}
				row += 1;
			}
			ConnectionUtil.closeResultSet(resultSet);
			ConnectionUtil.closeCallableStatement(callableStatement);
			ConnectionUtil.closeConnection(connection);

			log.debug("Query resulted : " + row + " row(s) ");
		} catch (SQLException fuckingException) {
			data.put(1, "ERROR", fuckingException.getLocalizedMessage());
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		log.debug("Query executed on " + (stopwatch.elapsed(TimeUnit.MICROSECONDS)) + " us");

		return data;
	}

	private String constructStoreProcQuery(String storeProcedureName,
			int parameterSize) {
		StringBuffer bufferQuery = new StringBuffer();
		bufferQuery.append("call " + storeProcedureName);
		bufferQuery.append("(");
		for (int i = 0; i < parameterSize; i++) {
			bufferQuery.append("?,");
		}
		bufferQuery.append("?)");
		return bufferQuery.toString();
	}
}
