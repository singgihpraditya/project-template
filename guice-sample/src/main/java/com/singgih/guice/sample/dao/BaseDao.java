package com.singgih.guice.sample.dao;

import java.util.List;

public interface BaseDao<X> {
	public void doSomething(X object);
}
