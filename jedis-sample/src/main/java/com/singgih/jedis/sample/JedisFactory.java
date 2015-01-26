package com.singgih.jedis.sample;

import org.apache.log4j.Logger;

public class JedisFactory {
	static Logger log = Logger.getLogger("com.singgih.jedis.sample");
	
	private static MyJedis jedis;
	
	public static MyJedis getJedisInstance(String host, int port){

		if(jedis == null){
			log.debug("Create new redis connection to : "+host+":"+port);
			jedis = new MyJedis(host, port);
		}
		return jedis;
	}
}
