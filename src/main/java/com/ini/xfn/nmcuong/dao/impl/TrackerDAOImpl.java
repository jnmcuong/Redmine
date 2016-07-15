package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;







import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.TrackerDAO;
import com.ini.xfn.nmcuong.domain.Member;
import com.ini.xfn.nmcuong.domain.Tracker;

@Repository
public class TrackerDAOImpl implements TrackerDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Tracker> getAll() {
		Session session = sessionFactory.openSession();
		List<Tracker> listTracker = session.createQuery("from Tracker").list();
		session.close();
		return listTracker;
		//return sessionFactory.getCurrentSession().createQuery("from Tracker").list();
	}

	@Transactional(readOnly = true)
	public Tracker getById(int id) {
		return (Tracker) sessionFactory.getCurrentSession().get(Tracker.class, id);
	}

	@Transactional
	public void save(Tracker tracker) {
		sessionFactory.getCurrentSession().saveOrUpdate(tracker);
	}

	@Transactional
	public void delete(int id) {
		Tracker tracker = (Tracker) sessionFactory.getCurrentSession().get(Tracker.class, id);
		sessionFactory.getCurrentSession().delete(tracker);
	}

}
