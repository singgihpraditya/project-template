package com.singgih.jsp.sample;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

/*
 The WebListener annotation is used to register the following types of listeners :
 - Context Listener (javax.servlet.ServletContextListener)
 - Context Attribute Listener (javax.servlet.ServletContextAttributeListener)
 - Servlet Request Listener (javax.servlet.ServletRequestListener)
 - Servlet Request Attribute Listener (javax.servlet.ServletRequestAttributeListener)
 - Http Session Listener (javax.servlet.http.HttpSessionListener)
 - Http Session Attribute Listener (javax.servlet.http.HttpSessionAttributeListener)
 */

@WebListener
public class SimpleListener implements ServletContextListener {
	Logger log = Logger.getLogger("com.singgih.jsp");

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		log.debug("Context Destroyed : " + servletContextEvent.getSource());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		log.debug("Context Initialized : " + servletContextEvent.getSource());
	}

}
