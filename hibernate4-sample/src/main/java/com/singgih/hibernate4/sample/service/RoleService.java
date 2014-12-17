package com.singgih.hibernate4.sample.service;

import java.util.List;

import com.singgih.hibernate4.sample.entity.Role;


public interface RoleService extends BaseService<Role> {
	public List<Role> getRoleWithAccessList();
}
