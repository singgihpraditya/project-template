package com.singgih.hibernate4.sample.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

public class HibernateUtil {
	static Logger log = Logger.getLogger("com.singgih.hibernate4");
	private static final SessionFactory sessionFactory = buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable fuckingException) {
			log.error("Initial SessionFactory creation failed." + fuckingException);
			throw new ExceptionInInitializerError(fuckingException);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
