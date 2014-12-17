package com.singgih.jersey.rest.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.singgih.jersey.rest.util.FileUtil;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;

@Path("/upload")
public class UploadService {
	Logger log = Logger.getLogger("com.singgih.jersey.rest");

	@POST
	@Path("/single")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response singleUploadFile(
			@FormDataParam("id") String id,
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {

		String uploadedFileLocation = "d://ormis/" + fileDetail.getFileName();
		log.debug("user id : " + id + ", write to file : " + uploadedFileLocation);
		String output = "File uploaded to : " + uploadedFileLocation;
		try {
			new FileUtil().writeToFile(uploadedInputStream, uploadedFileLocation);
		} catch (IOException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return Response.status(200).entity(output).build();
	}

	@POST
	@Path("/multiple")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response multipleUploadFile(@FormDataParam("id") String id, FormDataMultiPart multiPart) {
		List<FormDataBodyPart> fields = multiPart.getFields("file");
		for (FormDataBodyPart field : fields) {
			String uploadedFileLocation = "d://ormis/" + field.getContentDisposition().getFileName();
			log.debug("user id : " + id + ", write to file : " + uploadedFileLocation);
			try {
				new FileUtil().writeToFile(field.getValueAs(InputStream.class), uploadedFileLocation);
			} catch (IOException fuckingException) {
				log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
				fuckingException.printStackTrace();
			}
		}
		return Response.status(200).entity("OK").build();
	}

}