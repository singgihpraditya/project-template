package com.singgih.hibernate4.sample.dao;

import java.util.List;

import com.singgih.hibernate4.sample.entity.User;

public interface UserDao extends BaseDao {
	public List<User> getUserWithRoleList();
}