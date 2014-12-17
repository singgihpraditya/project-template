package test.com.singgih.gson.sample;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.singgih.gson.sample.service.GsonService;
import com.singgih.gson.sample.vo.RoleVo;
import com.singgih.gson.sample.vo.UserVo;

public class TestGson {
	Logger log = Logger.getLogger("com.singgih.gson");
	
	private static String jsonString = null;
	private static GsonService gsonService;
	
	@BeforeClass
	public static void init() {
		gsonService = new GsonService();
	}

	@Test
	public void testToString() {
		UserVo user = new UserVo();
		user.setUserId(1);
		user.setFirstName("singgih");
		user.setLastName("praditya");
		List<RoleVo> roles = new ArrayList<RoleVo>();
		for (int i = 0; i < 3; i++) {
			RoleVo role = new RoleVo();
			role.setName("role-" + i);
			roles.add(role);
		}
		user.setRoles(roles);
		
		jsonString = gsonService.toString(user);
		log.debug("json string "+jsonString);
	}
	
	@Test
	public void testToObject() {
		jsonString = "{\"userId\":1,\"firstName\":\"singgih\",\"lastName\":\"praditya\"}";
		UserVo user = (UserVo) gsonService.toObject(jsonString, UserVo.class);
		log.debug("object "+user);
	}
}
