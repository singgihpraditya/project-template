package com.singgih.velocity.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;
import com.singgih.velocity.menu.Menu;
import com.singgih.velocity.menu.MenuVo;
import com.singgih.velocity.menu.Role;
import com.singgih.velocity.menu.RoleVo;

public class MenuBuilder {
	Logger log = Logger.getLogger("com.singgih.velocity");
	private Stopwatch stopwatch;
	
	protected void startTimer() {
		stopwatch = new Stopwatch().start();
	}

	protected void stopTimer() {
		stopwatch = new Stopwatch().start();
		log.debug("executed on " + (stopwatch.elapsed(TimeUnit.MICROSECONDS)) + " us");
	}
	public Role getRoleWithMenu() {
		Role role = new Role();
		role.setId(1);
		role.setName("Administrator");
		List<Menu> grantedMenu = new ArrayList<Menu>();
		for (int i = 0; i < 10; i++) {
			Menu menu = new Menu();
			menu.setId(getUUID());
			menu.setName("Menu-" + i);
			for (int j = 0; j < i; j++) {
				Menu subMenu = new Menu();
				subMenu.setId(getUUID());
				subMenu.setName("SubMenu-" + i + "_" + j);
				subMenu.setParent(menu);
				for (int k = 0; k < j; k++) {
			
					Menu subSubMenu = new Menu();
					subSubMenu.setId(getUUID());
					subSubMenu.setName("SubMenu-" + i + "_" + j + "_" + k);
					
					subSubMenu.setParent(subMenu);
//					log.debug("subsubmenu : "+subSubMenu);
					grantedMenu.add(subSubMenu);
				}
//				log.debug("--------------------");
				grantedMenu.add(subMenu);
			}
			grantedMenu.add(menu);
		}
//		log.debug(grantedMenu);
		role.setGrantedMenu(grantedMenu);
		return role;
	}

	public RoleVo reAlignMenu() {
		startTimer();
		Role role = getRoleWithMenu();
		RoleVo roleVo = new RoleVo();
		roleVo.setId(role.getId());
		roleVo.setName(role.getName());

		List<Menu> grantedMenu = role.getGrantedMenu();
		List<MenuVo> rootMenu = new ArrayList<MenuVo>();
		for (Menu menu : grantedMenu) {
			if (menu.getParent() == null) {
				MenuVo menuVo = new MenuVo();
				menuVo.setId(menu.getId());
				menuVo.setName(menu.getName());
				fillSubmenu(menuVo, grantedMenu);
				rootMenu.add(menuVo);
			}
		}
		roleVo.setGrantedMenu(rootMenu);
		stopTimer();
		return roleVo;

	}

	private void fillSubmenu(MenuVo parentMenu, List<Menu> grantedMenu) {
	
		List<MenuVo> subMenus = new ArrayList<MenuVo>();
//		log.debug("parentMenu : "+parentMenu.getId()+", subMenu get Parent : "+menu.getParent().getId());
		
		for (Menu menu : grantedMenu) {
			if (menu.getParent() != null && menu.getParent().getId() == parentMenu.getId()) {
//				log.debug("parentMenu : "+parentMenu.getId()+", subMenu get Parent : "+menu.getParent().getId());
				MenuVo menuVo = new MenuVo();
				menuVo.setId(menu.getId());
				menuVo.setName(menu.getName());
				fillSubmenu(menuVo, grantedMenu);
//				log.debug("menu vo :"+menuVo);
				subMenus.add(menuVo);
			}
		}
		parentMenu.setSubMenus(subMenus);
//		log.debug("parent menu "+parentMenu);
	}
	
	private String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}

}
