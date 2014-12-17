package com.singgih.gson.sample.vo;

import java.util.List;

import com.google.common.base.Objects;

public class UserVo {
	private int userId;
	private String firstName;
	private String lastName;
	private List<RoleVo> roles;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<RoleVo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVo> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(getClass()).add("userId", userId)
				.add("firstName", firstName).add("lastName", lastName).add("roles", roles)
				.toString();
	}
}
