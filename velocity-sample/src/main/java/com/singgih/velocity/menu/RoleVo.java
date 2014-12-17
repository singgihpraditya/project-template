package com.singgih.velocity.menu;

import java.util.List;

import com.google.common.base.Objects;

public class RoleVo {
	private int id;
	private String name;
	private List<MenuVo> grantedMenu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuVo> getGrantedMenu() {
		return grantedMenu;
	}

	public void setGrantedMenu(List<MenuVo> grantedMenu) {
		this.grantedMenu = grantedMenu;
	}

	public String toString() {
		return Objects.toStringHelper(getClass()).add("id", id)
				.add("name", name).add("grantedMenu", grantedMenu).toString();
	}
}
