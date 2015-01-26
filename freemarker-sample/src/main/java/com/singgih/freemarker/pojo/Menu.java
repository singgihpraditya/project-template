package com.singgih.freemarker.pojo;

import java.util.List;

public class Menu {
	private String name;
	private String url;
	private List<Menu> subMenu;

	public Menu() {

	}

	public Menu(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public Menu(String name, String url, List<Menu> subMenu) {
		this.name = name;
		this.url = url;
		this.subMenu = subMenu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}
}
