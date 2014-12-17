package com.singgih.hibernate4.sample.service.impl;

import java.util.List;

import com.google.inject.Inject;
import com.singgih.hibernate4.sample.dao.RoleDao;
import com.singgih.hibernate4.sample.entity.Role;
import com.singgih.hibernate4.sample.service.RoleService;

public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	@Inject
	private RoleDao roleDao;

	public List<Role> getRoleWithAccessList() {
		return roleDao.getRoleWithAccessList();
	}
}
