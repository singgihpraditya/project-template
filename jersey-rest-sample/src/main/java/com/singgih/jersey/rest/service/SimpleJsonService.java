package com.singgih.jersey.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.singgih.jersey.rest.vo.ArtistVo;
import com.singgih.jersey.rest.vo.MerchantVo;
import com.singgih.jersey.rest.vo.TrackVo;

@Path("/json")
public class SimpleJsonService extends BaseService {
	Logger log = Logger.getLogger("com.singgih.jersey.rest");

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public TrackVo getTrackInJson() {
		TrackVo track = new TrackVo();
		track.setCode(SUCCESS);
		track.setTitle("Enter Sandman");
		track.setReleaseDate(new Date());
		track.setCreatedDateTime(new Date());
		ArtistVo singer = new ArtistVo();
		singer.setName("Metallica");
		track.setSinger(singer);
		List<MerchantVo> merchants = new ArrayList<MerchantVo>();
		for(int i=0;i<3;i++){
			MerchantVo merchant = new MerchantVo();
			merchant.setName("merc"+i);
			merchant.setAddress("add"+i);
			merchants.add(merchant);
		}
		track.setMerchants(merchants);
		return track;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TrackVo createTrackInJson(TrackVo track) {
		track.setCode(SUCCESS);
		log.debug("track : " + track.toString());
		return track;
	}
}