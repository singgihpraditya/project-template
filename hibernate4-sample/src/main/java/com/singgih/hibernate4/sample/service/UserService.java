package com.singgih.hibernate4.sample.service;

import java.util.List;

import com.singgih.hibernate4.sample.entity.User;


public interface UserService extends BaseService<User> {
	public List<User> getUserWithRoleList();
}
