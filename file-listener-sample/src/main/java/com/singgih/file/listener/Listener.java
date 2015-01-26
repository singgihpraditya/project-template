package com.singgih.file.listener;

import org.apache.log4j.Logger;

public class Listener {
	Logger log = Logger.getLogger("com.singgih.file.listener");

	public void listen(String path, int delay) {
		while (true) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("running");
		}
	}
}
