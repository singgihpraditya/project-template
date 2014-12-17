package com.singgih.jersey.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.singgih.jersey.rest.vo.ArtistVo;
import com.singgih.jersey.rest.vo.MerchantVo;
import com.singgih.jersey.rest.vo.TrackVo;

@Path("/text")
public class SimpleTextService extends BaseService {
	Logger log = Logger.getLogger("com.singgih.jersey.rest");
//	@Context private HttpServletRequest request;
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_HTML)
	public Response getTrackInJson() {
		TrackVo track = new TrackVo();
		track.setCode(SUCCESS);
		track.setTitle("Enter Sandman");
		track.setReleaseDate(new Date());
		track.setCreatedDateTime(new Date());
		ArtistVo singer = new ArtistVo();
		singer.setName("Metallica");
		track.setSinger(singer);
		List<MerchantVo> merchants = new ArrayList<MerchantVo>();
		for (int i = 0; i < 3; i++) {
			MerchantVo merchant = new MerchantVo();
			merchant.setName("merc" + i);
			merchant.setAddress("add" + i);
			merchants.add(merchant);
		}
		track.setMerchants(merchants);
		return Response.status(200).entity(track.toString()).build();
	}

	@POST
	@Path("/post")
	public Response createTrackInJson(TrackVo track) {
		track.setCode(SUCCESS);
		log.debug("track : " + track.toString());
		return Response.status(200).entity(track).build();
	}
}