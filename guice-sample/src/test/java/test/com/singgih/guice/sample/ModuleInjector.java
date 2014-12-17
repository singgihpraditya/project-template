package test.com.singgih.guice.sample;

import com.google.inject.AbstractModule;
import com.singgih.guice.sample.dao.BaseDao;
import com.singgih.guice.sample.dao.BaseDaoHibernateImpl;
import com.singgih.guice.sample.dao.UserDao;
import com.singgih.guice.sample.dao.UserDaoImpl;
import com.singgih.guice.sample.service.UserService;
import com.singgih.guice.sample.service.UserServiceImpl;

public class ModuleInjector extends AbstractModule {
	@Override
	protected void configure() {
		bind(BaseDao.class).to(BaseDaoHibernateImpl.class);
		bind(UserDao.class).to(UserDaoImpl.class);
		bind(UserService.class).to(UserServiceImpl.class);
	}
}
