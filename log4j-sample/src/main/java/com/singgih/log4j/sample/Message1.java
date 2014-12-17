package com.singgih.log4j.sample;

import org.apache.log4j.Logger;

public class Message1 {
	Logger log = Logger.getLogger("com.singgih.log4j.sample.Message1");

	public void writeMessage() {
		log.debug("This is my debug message from class :"
				+ this.getClass().getName());
		log.info("This is my info message from class :"
				+ this.getClass().getName());
		log.warn("This is my warn message from class :."
				+ this.getClass().getName());
		log.error("This is my error message from class :."
				+ this.getClass().getName());
		log.fatal("This is my fatal message from class :"
				+ this.getClass().getName());
	}
}
