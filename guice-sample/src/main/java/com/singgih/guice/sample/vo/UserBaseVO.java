package com.singgih.guice.sample.vo;

import java.io.Serializable;

public class UserBaseVO extends BaseVo implements Serializable {
	private static final long serialVersionUID = -2560681982733960674L;

	private String name;
	private String[] roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getRoles() {
		if (roles == null) {
			roles = new String[] {};
		}
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
}
