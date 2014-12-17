package com.singgih.hibernate4.sample.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.singgih.hibernate4.sample.dao.RoleDao;
import com.singgih.hibernate4.sample.entity.Role;
import com.singgih.hibernate4.sample.util.HibernateUtil;

public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {
	public RoleDaoImpl() {
		super(Role.class);
	}
	
	/* (non-Javadoc)
	 * @see com.singgih.hibernate4.sample.dao.impl.RoleDao#getRoleWithAccessList()
	 */
	public List<Role> getRoleWithAccessList() {
		startTimer();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Role> list = (List<Role>) session.createQuery("from Role r inner join fetch r.grantedAccess").list();
		session.close();
		stopTimer();
		return list;
	}
}
