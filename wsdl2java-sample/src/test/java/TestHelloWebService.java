import java.net.URL;

import org.junit.Test;

import com.singgih.webservice.sample.HelloWebService;
import com.singgih.webservice.sample.HelloWebServiceService;


public class TestHelloWebService {
	@Test
	public void testService(){
		URL url = this.getClass().getClassLoader().getResource("wsdl/service.wsdl");
		HelloWebService helloWebService = new HelloWebServiceService(url).getHelloWebServicePort();
		String returnString = helloWebService.sayHello("foobar");
		System.out.println(returnString);
	}
}
