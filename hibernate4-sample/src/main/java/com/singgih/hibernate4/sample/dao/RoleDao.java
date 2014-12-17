package com.singgih.hibernate4.sample.dao;

import java.util.List;

import com.singgih.hibernate4.sample.entity.Role;

public interface RoleDao extends BaseDao {
	public List<Role> getRoleWithAccessList();
}