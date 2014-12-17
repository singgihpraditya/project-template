package com.singgih.struts.sample.action;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {
	private static final long serialVersionUID = -6115784590724907305L;

	Logger log = Logger.getLogger("com.singgih.struts");

	protected final String SUCCESS = "success";
	protected final String FAILED = "failed";

	private Stopwatch stopwatch = null;

	
	protected void startTimer() {
		stopwatch = new Stopwatch().start();
	}

	protected void stopTimer() {
		log.debug("executed on " + (stopwatch.elapsed(TimeUnit.MILLISECONDS)) + " ms");
	}

}
