package com.singgih.guice.sample.dao;

import java.lang.reflect.ParameterizedType;

import com.singgih.guice.sample.vo.BaseDomain;

public class BaseDaoHibernateImpl<X extends BaseDomain>
		implements BaseDao<X> {
	private Class<X> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoHibernateImpl() {
		this.clazz = (Class<X>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public void doSomething(X object) {
		System.out.println(object);
	}
}
