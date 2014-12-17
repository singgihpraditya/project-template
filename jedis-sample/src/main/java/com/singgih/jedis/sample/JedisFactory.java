package com.singgih.jedis.sample;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

public class JedisFactory {
	static Logger log = Logger.getLogger("com.singgih.jedis.sample");
	
	private static Jedis jedis;
	
	public static Jedis getJedisInstance(){
		String host = "localhost";
		int port = 6379;
		
		if(jedis == null){
			log.debug("Create new redis connection to : "+host+":"+port);
			jedis = new Jedis("localhost", 6379);
		}
		return jedis;
	}
}
