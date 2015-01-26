package com.singgih.spring.sample.vo;

import java.util.List;

public class RoleVo {
	private String roleName;
	private List<MenuVo> grantedMenus;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<MenuVo> getGrantedMenus() {
		return grantedMenus;
	}

	public void setGrantedMenus(List<MenuVo> grantedMenus) {
		this.grantedMenus = grantedMenus;
	}
}
