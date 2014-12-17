package test.com.singgih.hibernate4.sample;

import java.util.List;

import org.jboss.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.singgih.hibernate4.sample.entity.Role;
import com.singgih.hibernate4.sample.service.RoleService;
import com.singgih.hibernate4.sample.util.ModuleInjector;

public class TestRoleService {
	Logger log = Logger.getLogger("com.singgih.hibernate4");

	private static RoleService roleService;
	@BeforeClass
	public static void initTest() {
		Injector injector = Guice.createInjector(new ModuleInjector());
		roleService = injector.getInstance(RoleService.class);
	}

	@Test
	public void testGetAll() {
		List<Role> roleList = roleService.getRoleWithAccessList();
		for (Role role : roleList) {
			
		}
	}

}
