package com.singgih.velocity.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class FormatterUtil {
	public String formatDate(Date date, String format) {
		try {
			return new SimpleDateFormat(format).format(date);
		} catch (Exception fuckingException) {
			fuckingException.printStackTrace();
			return null;
		}
	}

	public String formatLong(Long number, String format) {
		return "";
	}

	public String formatInteger(Integer number, String format) {
		return "";
	}

	public String formatDouble(Double number, String format) {
		return "";
	}
}
