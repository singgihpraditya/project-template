package test.com.singgih.jersey.rest.http.client;

import java.util.Date;

import org.junit.Test;

import com.singgih.jersey.rest.util.XmlUtil;
import com.singgih.jersey.rest.vo.ArtistVo;
import com.singgih.jersey.rest.vo.TrackVo;

public class TestToXML {
	@Test
	public void testToXML() {
		TrackVo track = new TrackVo();
		track.setTitle("Enter Sandman");
		ArtistVo singer = new ArtistVo();
		singer.setName("Metallica");
		track.setSinger(singer);
		track.setReleaseDate(new Date());
		String xml = new XmlUtil().toXml(track);
		System.out.println(xml);

		TrackVo trackVo2 = (TrackVo) new XmlUtil().toObject(xml, TrackVo.class);
		System.out.println(trackVo2);
	}
}
