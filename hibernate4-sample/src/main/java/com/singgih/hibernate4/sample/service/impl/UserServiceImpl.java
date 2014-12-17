package com.singgih.hibernate4.sample.service.impl;

import java.util.List;

import com.google.inject.Inject;
import com.singgih.hibernate4.sample.dao.UserDao;
import com.singgih.hibernate4.sample.entity.User;
import com.singgih.hibernate4.sample.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Inject
	private UserDao userDao;

	public List<User> getUserWithRoleList() {
		// TODO Auto-generated method stub
		return userDao.getUserWithRoleList();
	}
}
