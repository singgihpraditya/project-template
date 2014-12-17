package com.singgih.jersey.rest.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;

public class RestHttpClient {
	Logger log = Logger.getLogger("com.singgih.jersey.rest");

	private Stopwatch stopwatch = null;

	private void startTimer() {
		stopwatch = new Stopwatch().start();
	}

	private void stopTimer() {
		log.debug("executed on " + (stopwatch.elapsed(TimeUnit.MILLISECONDS)) + " ms");
	}

	public String doGetJson(String url) {
		startTimer();
		log.debug("GET : " + url);
		String output = doGet(url, "application/json");
		stopTimer();
		return output;
	}

	public String doGetXml(String url) {
		startTimer();
		log.debug("GET : " + url);
		String output = doGet(url, "application/xml");
		stopTimer();
		return output;
	}

	public String doGet(String url, String contentType) {
		String output = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(url);
			getRequest.addHeader("accept", contentType);
			HttpResponse response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			output = br.readLine();
			log.debug("Output : " + output);
			httpClient.getConnectionManager().shutdown();
		} catch (ClientProtocolException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();

		} catch (IOException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		stopTimer();
		return output;
	}

	public String doPostJson(String url, String input) {
		startTimer();
		log.debug("POST : " + url);
		String output = doPost(url, input, "application/json");
		stopTimer();
		return output;
	}

	public String doPostXml(String url, String input) {
		startTimer();
		log.debug("POST : " + url);
		String output = doPost(url, input, "application/xml");
		stopTimer();
		return output;
	}

	public String doPost(String url, String input, String contentType) {
		String output = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(url);
			StringEntity stringEntity = new StringEntity(input);
			stringEntity.setContentType(contentType);
			postRequest.setEntity(stringEntity);
			HttpResponse response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			output = br.readLine();
			log.debug("Output : " + output);
			httpClient.getConnectionManager().shutdown();
		} catch (MalformedURLException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (HttpHostConnectException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (ClientProtocolException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (UnsupportedEncodingException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (IOException fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return output;
	}
}
