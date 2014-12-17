package com.singgih.gson.sample.service;

import com.google.gson.Gson;

public class GsonService {
	public Object toObject(String json, Class clazz) {
		Gson gson = new Gson();
		Object object = gson.fromJson(json, clazz);
		return object;
	}

	public String toString(Object object) {
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
	}
}
