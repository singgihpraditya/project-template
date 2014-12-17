package com.singgih.quartz.sample;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTrigger {
	Logger log = Logger.getLogger("com.singgih.quartz");

	public void runScheduler() {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = null;
		try {
			sched = sf.getScheduler();
			JobDetail job = new JobDetail("job", "group1", SimpleJob.class);
			JobDataMap jobDataMap = new JobDataMap();
			jobDataMap.put("message", "Hello");
			job.setJobDataMap(jobDataMap);
			CronTrigger trigger = new CronTrigger("trigger1", "group1", "job", "group1", "0/5 * * * * ?");
			sched.scheduleJob(job, trigger);
			sched.addJob(job, true);
			sched.start();
		} catch (SchedulerException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (ParseException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}

	}
}
