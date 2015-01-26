package test.com.singgih.guice.sample;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.singgih.guice.injector.ModuleInjector;
import com.singgih.guice.sample.SingletonService;

public class TestGuiceService {

	Logger log = Logger.getLogger("com.singgih.guice");

	@Test
	public void testSingletonService(){
		Injector injector = Guice.createInjector(new ModuleInjector());
		SingletonService singletonService1 = injector.getInstance(SingletonService.class);
		singletonService1.setCounter(5);
		SingletonService singletonService2 = injector.getInstance(SingletonService.class);
		Assert.assertEquals(5, singletonService2.getCounter());	
	}
}
