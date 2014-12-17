package test.com.singgih.log4j.sample;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.singgih.log4j.sample.Message1;
import com.singgih.log4j.sample.Message2;

public class TestLog4J {
	static Logger log = Logger.getLogger("com.singgih.log4j.sample.TestLog4J");

	@Test
	public void testParseData() {
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

		Message1 m1 = new Message1();
		m1.writeMessage();
		Message2 m2 = new Message2();
		m2.writeMessage();

	}

}
