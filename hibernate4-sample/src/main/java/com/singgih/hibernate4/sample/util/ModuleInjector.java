package com.singgih.hibernate4.sample.util;

import com.google.inject.AbstractModule;
import com.singgih.hibernate4.sample.dao.AccessDao;
import com.singgih.hibernate4.sample.dao.RoleDao;
import com.singgih.hibernate4.sample.dao.UserDao;
import com.singgih.hibernate4.sample.dao.impl.AccessDaoImpl;
import com.singgih.hibernate4.sample.dao.impl.RoleDaoImpl;
import com.singgih.hibernate4.sample.dao.impl.UserDaoImpl;
import com.singgih.hibernate4.sample.service.AccessService;
import com.singgih.hibernate4.sample.service.RoleService;
import com.singgih.hibernate4.sample.service.UserService;
import com.singgih.hibernate4.sample.service.impl.AccessServiceImpl;
import com.singgih.hibernate4.sample.service.impl.RoleServiceImpl;
import com.singgih.hibernate4.sample.service.impl.UserServiceImpl;

public class ModuleInjector extends AbstractModule {
	@Override
	protected void configure() {
		bind(UserDao.class).to(UserDaoImpl.class);
		bind(RoleDao.class).to(RoleDaoImpl.class);
		bind(AccessDao.class).to(AccessDaoImpl.class);
		
		bind(UserService.class).to(UserServiceImpl.class);
		bind(RoleService.class).to(RoleServiceImpl.class);
		bind(AccessService.class).to(AccessServiceImpl.class);
	}
}
