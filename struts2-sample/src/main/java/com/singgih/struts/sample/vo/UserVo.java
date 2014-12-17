package com.singgih.struts.sample.vo;

import java.util.List;

import com.google.common.base.Objects;

public class UserVo extends BaseVo {
	private String name;
	private RoleVo role;
	private List<GroupVo> groups;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleVo getRole() {
		return role;
	}

	public void setRole(RoleVo role) {
		this.role = role;
	}

	public List<GroupVo> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupVo> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(getClass())
				.add("name", name)
				.add("role", role)
				.add("groups", groups)
				.toString();
	} 
}
