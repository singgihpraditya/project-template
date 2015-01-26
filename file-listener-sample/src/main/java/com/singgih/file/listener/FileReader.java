package com.singgih.file.listener;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class FileReader {
	Logger log = Logger.getLogger("com.singgih.file.listener");

	public String readFile(String path) {
		log.debug("Read file : " + path);
		String text = null;
		try {
			text = Files.toString(new File(path), Charsets.UTF_8);
			removeFile(path);
		} catch (IOException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return text;
	}
	
	private boolean removeFile(String path){
		File file = new File(path);
		return file.delete();
	}
}
