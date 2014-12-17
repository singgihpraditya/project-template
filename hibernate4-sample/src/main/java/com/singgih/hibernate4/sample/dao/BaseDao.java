package com.singgih.hibernate4.sample.dao;

import java.util.List;

import com.singgih.hibernate4.sample.entity.BaseEntity;

public interface BaseDao {
	public List list();

	public Object getById(String id);

	public BaseEntity update(BaseEntity object);

	public void insert(BaseEntity object);

	public void remove(String id);

}