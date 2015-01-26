package com.singgih.jsonpath.sample;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.jayway.jsonpath.JsonPath;

public class JsonService {
	public Object parseJson(String json, String jxpath){
		return JsonPath.read(json, jxpath);
	}
	
	public String readFile(String path) {
		String text = null;
		try {
			text = Files.toString(new File(path), Charsets.UTF_8);
		} catch (IOException fuckingException) {
			fuckingException.printStackTrace();
		}
		return text;
	}
}
