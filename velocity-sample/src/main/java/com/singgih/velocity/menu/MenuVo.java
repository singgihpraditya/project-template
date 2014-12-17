package com.singgih.velocity.menu;

import java.util.List;

import com.google.common.base.Objects;

public class MenuVo {
	private String id;
	private String name;
	private List<MenuVo> subMenus;
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuVo> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<MenuVo> subMenus) {
		this.subMenus = subMenus;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String ur) {
		this.url = ur;
	}

	public String toString() {
		return Objects.toStringHelper(getClass()).add("id", id)
				.add("name", name).add("subMenu", subMenus)
				.add("url", url).toString();
	}
}
