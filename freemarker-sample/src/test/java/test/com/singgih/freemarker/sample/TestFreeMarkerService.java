package test.com.singgih.freemarker.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.singgih.freemarker.sample.FreeMarkerService;

public class TestFreeMarkerService {

	Logger log = Logger.getLogger("com.singgih.freemarker");
	
	@Test
	public void testRender() {
		String path = "freemarker.ftl";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Pesan");
		
		List<String> countries = new ArrayList<String>();
		countries.add("India");
		countries.add("United States");
		countries.add("Germany");
		countries.add("France");

		map.put("size", 10);
		
		map.put("countries", countries);
		
		String result = new FreeMarkerService().render(path, map);
		log.debug("result : "+result);

	}
}
