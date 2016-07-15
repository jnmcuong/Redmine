package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.StatusDAO;
import com.ini.xfn.nmcuong.domain.Status;
import com.ini.xfn.nmcuong.domain.Tracker;

@Repository
public class StatusDAOImpl implements StatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Status> getAll() {
		Session session = sessionFactory.openSession();
		List<Status> listStatus = session.createQuery("from Status").list();
		session.close();
		return listStatus;
	}

	@Transactional(readOnly = true)
	public Status getById(int id) {
		return (Status) sessionFactory.getCurrentSession().get(Status.class, id);
	}

	@Transactional
	public void save(Status status) {
		sessionFactory.getCurrentSession().saveOrUpdate(status);
	}

	@Transactional
	public void delete(int id) {
		Status status = (Status) sessionFactory.getCurrentSession().get(Status.class, id);
		sessionFactory.getCurrentSession().delete(status);
	}

}
