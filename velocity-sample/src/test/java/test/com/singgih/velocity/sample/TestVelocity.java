package test.com.singgih.velocity.sample;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.singgih.velocity.sample.WebBaseVelocityUtil;

public class TestVelocity {
	@Test
	public void testMergeTemplate() {
		String vmName = "example.vm";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "messagenya");
		String result = new WebBaseVelocityUtil().stringFromVm(vmName, map);
		System.out.println(result);
	}
}
