package com.singgih.struts.sample.vo;

import com.google.common.base.Objects;

public class UserVo extends BaseVo {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(getClass())
				.add("id", id)
				.add("name", name)
				.toString();
	}
}
