package com.singgih.hibernate4.sample.dao.impl;

import com.singgih.hibernate4.sample.dao.AccessDao;
import com.singgih.hibernate4.sample.entity.Access;

public class AccessDaoImpl extends BaseDaoImpl implements AccessDao {
	public AccessDaoImpl() {
		super(Access.class);
	}
}
