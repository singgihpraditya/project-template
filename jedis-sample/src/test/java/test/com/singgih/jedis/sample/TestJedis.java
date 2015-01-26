package test.com.singgih.jedis.sample;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.singgih.jedis.sample.JedisFactory;
import com.singgih.jedis.sample.MyJedis;

public class TestJedis {
	Logger log = Logger.getLogger("com.singgih.jedis.sample");

	@Test
	public void testSet() {
		// JedisService jedisService = new JedisService();
		String host = "localhost";
		int port = 6379;
		String key = "test";
		String value = "foobar";
		MyJedis jedis = JedisFactory.getJedisInstance(host, port);

		jedis.set(key, value);
		Assert.assertEquals(value, jedis.get(key));
		
		jedis.disconnect();
	}
}
