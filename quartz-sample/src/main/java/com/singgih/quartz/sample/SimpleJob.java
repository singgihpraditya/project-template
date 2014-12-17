package com.singgih.quartz.sample;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {
	Logger log = Logger.getLogger("com.singgih.quartz");

	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.debug("InterfaceJob says: executing at " + new Date());

		JobDataMap jobDataMap = context.getMergedJobDataMap();
		String message = (String) jobDataMap.get("message");
		log.debug("Message : " + message);
	}

}
