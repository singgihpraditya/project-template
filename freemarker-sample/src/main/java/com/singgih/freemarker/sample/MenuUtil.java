package com.singgih.freemarker.sample;

import java.util.ArrayList;
import java.util.List;

import com.singgih.freemarker.pojo.Menu;

public class MenuUtil {
	public List<Menu> generateMenu() {
		List<Menu> menus = new ArrayList<Menu>();
		for (int i = 0; i < 5; i++) {
			Menu menuUtama = new Menu("name_" + i, "url_" + i);
			List<Menu> subMenus = new ArrayList<Menu>();
			for (int j = 0; j < 5; j++) {
				Menu subMenuUtama = new Menu("sub_name_" + i, "sub_url_" + i);
				subMenus.add(subMenuUtama);	
			}
			menuUtama.setSubMenu(subMenus);
		}
		return menus;
	}
}
