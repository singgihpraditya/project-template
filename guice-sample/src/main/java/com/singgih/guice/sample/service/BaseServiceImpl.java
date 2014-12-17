package com.singgih.guice.sample.service;

import java.lang.reflect.ParameterizedType;

import com.google.inject.Inject;
import com.singgih.guice.sample.dao.BaseDao;
import com.singgih.guice.sample.vo.BaseDomain;

public class BaseServiceImpl<X extends BaseDomain> implements BaseService<X> {

	private Class<X> domainClass;
	
	protected BaseDao<X> baseDao;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		this.domainClass = (Class<X>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public void doSomething(X object) {
		// TODO Auto-generated method stub
		baseDao.doSomething(object);
	}

	
}
