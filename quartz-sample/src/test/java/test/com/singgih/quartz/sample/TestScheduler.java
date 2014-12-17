package test.com.singgih.quartz.sample;

import org.junit.Test;

import com.singgih.quartz.sample.SimpleTrigger;

public class TestScheduler {
//	@Test
	public static void main(String[] args) {
		new SimpleTrigger().runScheduler();
	}
}
