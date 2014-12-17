package test.com.singgih.properties.util;

import org.junit.Test;

import com.singgih.properties.util.PropertiesUtil;

public class TestLoadProperties {
	
	private String fileName1 = "filename1.properties";
	private String fileName2 = "filename2.properties";
	
	
	@Test
	public void testLoadProperties(){
		for(int i=0;i<10;i++){
			String result1 = PropertiesUtil.getPropertyFromFile(fileName1, "key1");
			
			String result2 = PropertiesUtil.getPropertyFromFile(fileName2, "key2");
			String result3 = PropertiesUtil.getPropertyFromFile(fileName2, "key3","kosong");

			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result3);
		}
		
	}
}
