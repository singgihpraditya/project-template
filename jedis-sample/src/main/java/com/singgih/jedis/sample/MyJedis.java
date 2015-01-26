package com.singgih.jedis.sample;

import redis.clients.jedis.Jedis;

public class MyJedis extends Jedis {

	public MyJedis(String host, int port) {
		super(host, port);
	}

	public void set(String key, String value, int seconds) {
		super.set(key.getBytes(), value.getBytes());
		super.expire(key, seconds);
	}

	public void set(byte[] key, byte[] value, int seconds) {
		super.set(key, value);
		super.expire(key, seconds);
	}

	public void lpush(String key, String[] values) {
		for (String value : values) {
			super.lpush(key.getBytes(), value.getBytes());
		}
	}

	public void lpush(byte[] key, byte[][] values) {
		for (byte[] value : values) {
			super.lpush(key, value);
		}
	}

	public void sadd(String key, String[] values) {
		for (String value : values) {
			super.sadd(key.getBytes(), value.getBytes());
		}
	}

	public void sadd(byte[] key, byte[][] values) {
		for (byte[] value : values) {
			super.sadd(key, value);
		}
	}
}
