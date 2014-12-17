package com.singgih.guice.sample.service;

import com.google.inject.Inject;
import com.singgih.guice.sample.dao.UserDao;
import com.singgih.guice.sample.vo.User;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Inject
	private UserDao userDao;
	
	public UserServiceImpl() {
		super.baseDao = userDao;
		System.out.println(userDao);
	}
	@Override
	public void doSomething(User object) {
		// TODO Auto-generated method stub
		System.out.println(userDao);
//		userDao.doSomething(object);
	}
}
