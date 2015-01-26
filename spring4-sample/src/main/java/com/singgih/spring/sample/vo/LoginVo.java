package com.singgih.spring.sample.vo;

import com.google.common.base.Objects;

public class LoginVo {
	private String userName;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String toString() {
		return Objects.toStringHelper(getClass()).add("userName", userName)
				.add("password", password).toString();
	}
}
