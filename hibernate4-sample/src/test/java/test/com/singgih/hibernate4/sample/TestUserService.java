package test.com.singgih.hibernate4.sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.singgih.hibernate4.sample.dao.UserDao;
import com.singgih.hibernate4.sample.dao.impl.UserDaoImpl;
import com.singgih.hibernate4.sample.entity.Access;
import com.singgih.hibernate4.sample.entity.Role;
import com.singgih.hibernate4.sample.entity.User;
import com.singgih.hibernate4.sample.service.AccessService;
import com.singgih.hibernate4.sample.service.RoleService;
import com.singgih.hibernate4.sample.service.UserService;
import com.singgih.hibernate4.sample.util.ModuleInjector;

public class TestUserService {
	private static UserService userService;
	private static RoleService roleService;
	private static AccessService accessService;

	private static UserDao baseDao;

	Logger log = Logger.getLogger("com.singgih.hibernate4");

	@BeforeClass
	public static void initTest() {
		Injector injector = Guice.createInjector(new ModuleInjector());
		userService = injector.getInstance(UserService.class);
		roleService = injector.getInstance(RoleService.class);
		accessService = injector.getInstance(AccessService.class);
		baseDao = injector.getInstance(UserDaoImpl.class);
	}

	@Test
	public void testSave() {
		User user = new User();
		// user.setId(3);
		user.setFirstName("singgih");
		user.setGender("M");
		user.setBirthDate(new Date());

		List<Access> grantedAccess = new ArrayList<Access>();
		for (int i = 0; i < 5; i++) {
			Access access = new Access();
			access.setName("foo");
			accessService.insert(access);
			grantedAccess.add(access);
		}
		
		Role role = new Role();
		role.setName("foo");		
		role.setGrantedAccess(grantedAccess);
		roleService.insert(role);
		
		user.setRole(role);
		userService.insert(user);
	}

	@Test
	public void testGetAll() {
		List<User> userList = userService.getUserWithRoleList();
		for (User user : userList) {
			log.debug(user.getRole().getName());
		}
	}

}
