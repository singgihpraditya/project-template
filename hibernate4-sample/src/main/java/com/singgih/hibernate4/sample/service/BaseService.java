package com.singgih.hibernate4.sample.service;

import java.util.List;

public interface BaseService<T> {
	public List<T> list();
	public void remove(String id);
	public T update(T object);
	public void insert(T object);
	public T getById(String id);
}
