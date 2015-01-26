package com.singgih.lucene.sample.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class IndexFactory {
	public static Directory index;
	
	static Logger log = Logger.getLogger("com.singgih.lucene");

	public static Directory getIndex() {
		if(index == null){
			log.debug("Create new lucene index instance");
//			index = new RAMDirectory();
			try {
				index = FSDirectory.open(new File("e:/test-dir/index"));
			} catch (IOException fuckingException) {
				log.debug("Failed to create index file, exception : "+fuckingException.getLocalizedMessage());
				fuckingException.printStackTrace();
			}
		}
		
		return index;
	}
	
	public static void closeIndex(){
		if(index != null){
			try {
				index.close();
			} catch (IOException fuckingException) {
				log.debug("Failed to create index file, exception : "+fuckingException.getLocalizedMessage());
				fuckingException.printStackTrace();
			}
		}
	}
	

}
