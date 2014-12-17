package com.singgih.guice.sample.vo;

import java.io.Serializable;

import com.google.common.base.Objects;

public class User extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 164966374567761089L;

	private String name;

	public void setName(String userId) {
		this.name = userId;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return Objects.toStringHelper(getClass()).add("Id", id)
				.add("Name", name).add("Create By", createBy)
				.add("Create Time", createTime)
				.add("Last Update By", lastUpdateBy)
				.add("Last Update Time", lastUpdateTime).toString();
	}
}
