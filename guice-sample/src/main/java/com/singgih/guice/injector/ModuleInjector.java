package com.singgih.guice.injector;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.singgih.guice.sample.SingletonService;

public class ModuleInjector extends AbstractModule {
	@Override
	protected void configure() {
		bind(SingletonService.class).in(Scopes.SINGLETON);
	}
}
