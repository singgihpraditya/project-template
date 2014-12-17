package com.singgih.hibernate4.sample.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.jboss.logging.Logger;

import com.singgih.hibernate4.sample.dao.UserDao;
import com.singgih.hibernate4.sample.entity.User;
import com.singgih.hibernate4.sample.util.HibernateUtil;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	Logger log = Logger.getLogger("com.singgih.hibernate4");

	public UserDaoImpl() {
		super(User.class);
	}

	/* (non-Javadoc)
	 * @see com.singgih.hibernate4.sample.dao.impl.UserDao#getUserWithRoleList()
	 */
	public List<User> getUserWithRoleList() {
		startTimer();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> list = (List<User>) session.createQuery("from User u inner join fetch u.role").list();
		session.close();
		stopTimer();
		return list;
	}
}
