package com.singgih.hibernate4.sample.dao.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.jboss.logging.Logger;

import com.google.common.base.Stopwatch;
import com.singgih.hibernate4.sample.dao.BaseDao;
import com.singgih.hibernate4.sample.entity.BaseEntity;
import com.singgih.hibernate4.sample.util.HibernateUtil;

public class BaseDaoImpl implements BaseDao {
	Logger log = Logger.getLogger("com.singgih.hibernate4");

	private Class entityClass;
	private Stopwatch stopwatch = null;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl(Class entityClass) {
		this.entityClass = entityClass;
	}

	protected void startTimer() {
		stopwatch = new Stopwatch().start();
	}

	protected void stopTimer() {
		log.debug("Executed on : " + (stopwatch.elapsed(TimeUnit.MILLISECONDS)) + " ms");
	}

	/* (non-Javadoc)
	 * @see com.singgih.hibernate4.sample.dao.impl.BaseDao#list()
	 */
	public List list() {
		startTimer();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List list = (List) session.createQuery("from " + entityClass.getName()).list();
		session.close();
		stopTimer();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.singgih.hibernate4.sample.dao.impl.BaseDao#getById(java.lang.String)
	 */
	public Object getById(String id) {
		startTimer();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Object object = session.get(entityClass, id);
		session.close();
		stopTimer();
		return object;
	}

	/* (non-Javadoc)
	 * @see com.singgih.hibernate4.sample.dao.impl.BaseDao#update(com.singgih.hibernate4.sample.entity.BaseEntity)
	 */
	public BaseEntity update(BaseEntity object) {
		log.debug("Updating : " + entityClass.getName());
		startTimer();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			object = (BaseEntity) session.merge(object);
			session.getTransaction().commit();
		} catch (Exception fuckingException) {
			session.getTransaction().rollback();
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
		} finally {
			session.close();
		}
//		session.close();
		stopTimer();
		return object;
	}

	/* (non-Javadoc)
	 * @see com.singgih.hibernate4.sample.dao.impl.BaseDao#insert(com.singgih.hibernate4.sample.entity.BaseEntity)
	 */
	public void insert(BaseEntity object) {
		log.debug("Inserting : " + entityClass.getName());
		startTimer();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
		} catch (Exception fuckingException) {
			session.getTransaction().rollback();
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
		} finally {
			session.close();
		}
		stopTimer();
	}

	/* (non-Javadoc)
	 * @see com.singgih.hibernate4.sample.dao.impl.BaseDao#remove(java.lang.String)
	 */
	public void remove(String id) {
		log.debug("Removing : " + entityClass.getName());
		startTimer();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(getById(id));
			session.getTransaction().commit();
		} catch (Exception fuckingException) {
			session.getTransaction().rollback();
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
		} finally {
			session.close();
		}
		stopTimer();
	}
}
