package com.singgih.hibernate4.sample.vo;

import com.google.common.base.Objects;

public class RoleVo {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(getClass()).add("name", name).toString();
	}
}
