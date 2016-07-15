package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;







import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.PriorityDAO;
import com.ini.xfn.nmcuong.domain.Member;
import com.ini.xfn.nmcuong.domain.Priority;

@Repository
public class PriorityDAOImpl implements PriorityDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Priority> getAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Priority");
			return query.list();
		} finally {
			session.close();
		}
	}

	public Priority getById(int id) {
		Session session = sessionFactory.openSession();
		try {
			return (Priority) session.get(Priority.class, id);
		} finally {
			session.close();
		}
	}


	@Transactional
	public void save(Priority priority) {
		sessionFactory.getCurrentSession().saveOrUpdate(priority);
	}

	@Transactional
	public void delete(int id) {
		Priority priority = (Priority) sessionFactory.getCurrentSession().get(Priority.class, id);
		sessionFactory.getCurrentSession().delete(priority);
	}

}
