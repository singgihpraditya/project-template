package com.singgih.jersey.rest.service;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.singgih.jersey.rest.vo.ArtistVo;
import com.singgih.jersey.rest.vo.TrackVo;

@Path("/xml")
public class SimpleXmlService extends BaseService {
	Logger log = Logger.getLogger("com.singgih.jersey.rest");

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_XML)
	public TrackVo getTrackInXml() {
		TrackVo track = new TrackVo();
		track.setCode(SUCCESS);
		track.setTitle("Enter Sandman");
		track.setReleaseDate(new Date());
		ArtistVo singer = new ArtistVo();
		singer.setName("Metallica");
		track.setSinger(singer);
		return track;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public TrackVo createTrackInXml(TrackVo track) {
		track.setCode(SUCCESS);
		log.debug("track : " + track.toString());
		return track;
	}

}