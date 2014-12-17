package com.singgih.jersey.rest.adapter;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JsonDateSerializer implements JsonSerializer<Date> {
	public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return new JsonPrimitive(dateFormat.format(date));
	}
}
