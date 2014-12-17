package com.singgih.hibernate4.sample.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jboss.logging.Logger;

import com.google.common.base.Stopwatch;
import com.singgih.hibernate4.sample.dao.BaseDao;
import com.singgih.hibernate4.sample.dao.impl.BaseDaoImpl;
import com.singgih.hibernate4.sample.entity.BaseEntity;
import com.singgih.hibernate4.sample.service.BaseService;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
	Logger log = Logger.getLogger("com.singgih.hibernate4");

	private Class<T> domainClass;
	private Stopwatch stopwatch = null;
	private BaseDao baseDao;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		this.domainClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		baseDao = new BaseDaoImpl(domainClass);
	}

	protected void startTimer() {
		stopwatch = new Stopwatch().start();
	}

	protected void stopTimer() {
		log.debug("executed on " + (stopwatch.elapsed(TimeUnit.MILLISECONDS)) + " ms");
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		return (List<T>) baseDao.list();
	}

	public void remove(String id) {
		baseDao.remove(id);
	}

	@SuppressWarnings("unchecked")
	public T update(T object) {
		return (T) baseDao.update(object);
	}

	public void insert(T object) {
		baseDao.insert(object);
	}

	@SuppressWarnings("unchecked")
	public T getById(String id) {
		return (T) baseDao.getById(id);
	}

}
