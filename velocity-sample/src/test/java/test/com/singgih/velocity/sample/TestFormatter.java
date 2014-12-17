package test.com.singgih.velocity.sample;

import java.text.DecimalFormat;

import org.junit.Test;

public class TestFormatter {
	@Test
	public void testNumberFormat(){
		 DecimalFormat formatter = new DecimalFormat("#0.00");
		    double d = 4.05223;
		    System.out.println(formatter.format(d));
	}
}
