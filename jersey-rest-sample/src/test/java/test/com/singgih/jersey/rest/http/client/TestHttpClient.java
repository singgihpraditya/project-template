package test.com.singgih.jersey.rest.http.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.singgih.jersey.rest.http.client.RestHttpClient;
import com.singgih.jersey.rest.util.GsonUtil;
import com.singgih.jersey.rest.util.XmlUtil;
import com.singgih.jersey.rest.vo.ArtistVo;
import com.singgih.jersey.rest.vo.MerchantVo;
import com.singgih.jersey.rest.vo.TrackVo;

public class TestHttpClient {
	Logger log = Logger.getLogger("com.singgih.jersey.rest");

	private static GsonUtil gsonService = new GsonUtil();
	private static XmlUtil xmlService = new XmlUtil();
	private static String baseUri = "http://localhost:8080";
	private static RestHttpClient restHttpClient = new RestHttpClient();
	private static TrackVo track = null;

	@Test
	public void testGetJson() {
		String url = baseUri + "/rest/json/get";
		String json = restHttpClient.doGetJson(url);
		track = (TrackVo) gsonService.toObject(json, TrackVo.class);
		log.debug(track);
	}

	@Test
	public void testPostJson() {
		String url = baseUri + "/rest/json/post";
		track = new TrackVo();
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
		String json = gsonService.toString(track);
		log.debug("input : "+json);
		String result = restHttpClient.doPostJson(url, json);
		log.debug("result : " + result);

	}

	@Test
	public void testGetXml() {
		String url = baseUri + "/rest/xml/get";
		String json = restHttpClient.doGetXml(url);
		track = (TrackVo) xmlService.toObject(json, TrackVo.class);
		log.debug(track);
	}

	@Test
	public void testPostXml() {
		String url = baseUri + "/rest/xml/post";
		track = new TrackVo();
		track.setTitle("Enter Sandman");
		track.setReleaseDate(new Date());
		ArtistVo singer = new ArtistVo();
		singer.setName("Metallica");
		track.setSinger(singer);
		String xml = xmlService.toXml(track);
		String result = restHttpClient.doPostXml(url, xml);
		log.debug("result : " + result);

	}
}
