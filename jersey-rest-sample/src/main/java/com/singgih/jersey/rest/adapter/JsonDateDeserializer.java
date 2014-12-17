package com.singgih.jersey.rest.adapter;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class JsonDateDeserializer implements JsonDeserializer<Date> {
	Logger log = Logger.getLogger("com.singgih.jersey.rest");

	public Date deserialize(JsonElement dateString, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		String[] formats = new String[] { "dd/MM/yyyy HH:mm:ss", "dd/MM/yyyy"};
		Date releaseDate = null;
		for (String format : formats) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				releaseDate = dateFormat.parse(dateString.getAsString());
				log.debug("date : "+dateString.getAsString()+", "+releaseDate);
				break;
			} catch (ParseException e) {
				log.error("date : "+dateString+" not suitable");
			}
		}
		return releaseDate;
	}
}
