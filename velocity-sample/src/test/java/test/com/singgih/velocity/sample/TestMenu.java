package test.com.singgih.velocity.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.singgih.velocity.menu.MenuVo;
import com.singgih.velocity.menu.RoleVo;
import com.singgih.velocity.sample.WebBaseVelocityUtil;
import com.singgih.velocity.util.MenuBuilder;

public class TestMenu {
	Logger log = Logger.getLogger("com.singgih.velocity");


	public void testBuildMenu() {
		RoleVo role = new MenuBuilder().reAlignMenu();
		List<MenuVo> grantedMenu = role.getGrantedMenu();
		for (MenuVo menuVo : grantedMenu) {
			log.debug(menuVo.getName());
			List<MenuVo> subMenus = menuVo.getSubMenus();
			for (MenuVo subMenu : subMenus) {
				log.debug("\t" + subMenu.getName());
				for (MenuVo subSubMenu : subMenu.getSubMenus()) {
					log.debug("\t\t" + " " + subSubMenu.getName());
				}
			}

		}
		log.debug("role : " + role);
	}
	
	@Test
	public void testVelocityMenu(){
		RoleVo role = new MenuBuilder().reAlignMenu();
		List<MenuVo> grantedMenu = role.getGrantedMenu();
		String vmName = "menu.vm";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("grantedMenu", grantedMenu);
		String result = new WebBaseVelocityUtil().stringFromVm(vmName, map);
		System.out.println(result);
	}
}
