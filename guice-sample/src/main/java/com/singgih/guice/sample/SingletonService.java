package com.singgih.guice.sample;

public class SingletonService {
	int counter = 0;

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}

}
