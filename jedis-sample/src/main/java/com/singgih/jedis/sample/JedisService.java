package com.singgih.jedis.sample;

public class JedisService {
	public void set(String key, String value) {
		set(key.getBytes(), value.getBytes());
	}

	public void set(byte[] key, byte[] value) {
		JedisFactory.getJedisInstance().set(key, value);
	}
}
