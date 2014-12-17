package com.singgih.jersey.rest.util;

import java.util.Date;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.singgih.jersey.rest.adapter.JsonDateDeserializer;
import com.singgih.jersey.rest.adapter.JsonDateSerializer;

public class GsonUtil {
	Logger log = Logger.getLogger("com.singgih.jersey.rest");

	private Gson gson;

	public GsonUtil() {
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new JsonDateSerializer());
		gsonBuilder.registerTypeAdapter(Date.class, new JsonDateDeserializer());
		gson = gsonBuilder.create();
	}

	public Gson getGson() {
		return gson;
	}

	public Object toObject(String json, Class clazz) {
		Object object = gson.fromJson(json, clazz);
		return object;
	}

	public String toString(Object object) {
		String json = gson.toJson(object);
		return json;
	}

}
