package com.singgih.struts.sample.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class FileUploadAction extends BaseAction {
	private static final long serialVersionUID = -5785715519673784151L;
	
	Logger log = Logger.getLogger("com.singgih.struts");
	
	private File uploadedFile;

	public File getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(File uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public String save() {
		startTimer();
		if (uploadedFile != null) {
			File outputFile = new File("D:/ormis-log/uploaded.txt");
			FileInputStream inputStream;
			try {
				inputStream = new FileInputStream(uploadedFile);
				FileOutputStream outputStream = new FileOutputStream(outputFile);
				IOUtils.copy(inputStream, outputStream);
				inputStream.close();
				outputStream.close();
			} catch (FileNotFoundException fuckingException) {
				// TODO Auto-generated catch block
				fuckingException.printStackTrace();
			} catch (IOException fuckingException) {
				// TODO Auto-generated catch block
				fuckingException.printStackTrace();
			}
		}
		stopTimer();
		return SUCCESS;
	}

}
