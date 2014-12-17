package test.com.singgih.jedis.sample;

import java.text.ParseException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestJedis {
	Logger log = Logger.getLogger("com.singgih.jedis.sample");

	@Test
	public void testSet() throws ParseException {
        int responseLength = 32;
        String firstDetailReason = "aaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbb";
        String response1 = "";
        String response2 = "";
        
        if(firstDetailReason.length() > responseLength){
           response1 = firstDetailReason.substring(0, responseLength);
           response2 = firstDetailReason.substring(responseLength, firstDetailReason.length()<(responseLength * 2)?firstDetailReason.length():(responseLength * 2));
        }
        else{
        	 response1 = firstDetailReason;
        }
        System.out.println(toCenter("tralalala",32));
		System.out.println(response1);
		System.out.println(response2);
		
	}
	
	private String toCenter(String messageData,int paddingLength){
		  StringBuffer sbTokenData = new StringBuffer();
		int paddLeftLength = (paddingLength / 2) - ( messageData.length()/2);
        System.out.println(paddLeftLength);
        int paddRighLength = paddingLength - (paddLeftLength + messageData.length());
        char fillerLeft[] = new char[paddLeftLength];
        Arrays.fill(fillerLeft, ' ');
        char fillerRight[] = new char[paddRighLength];
        Arrays.fill(fillerRight, ' ');
        sbTokenData.append(fillerLeft);
        sbTokenData.append(messageData);
        sbTokenData.append(fillerRight);
        return sbTokenData.toString();
	}

}
