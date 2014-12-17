package test.com.singgih.guice.sample;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.singgih.guice.sample.service.UserService;
import com.singgih.guice.sample.vo.User;


public class TestGuice {
	private static UserService someVoService;
	@BeforeClass
	public static void initTest() {
		Injector injector = Guice.createInjector(new ModuleInjector());
		someVoService = injector.getInstance(UserService.class);
		
	}
	@Test
	public void testSomething(){
		someVoService.doSomething(new User());
	}
}
