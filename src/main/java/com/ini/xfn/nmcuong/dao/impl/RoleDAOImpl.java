package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.RoleDAO;
import com.ini.xfn.nmcuong.domain.Issue;
import com.ini.xfn.nmcuong.domain.Member;
import com.ini.xfn.nmcuong.domain.Priority;
import com.ini.xfn.nmcuong.domain.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public List<Role> getAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Role");
			return query.list();
		} finally {
			session.close();
		}
	}

	public Role getById(int id) {
		Session session = sessionFactory.openSession();
		try {
			return (Role) session.get(Role.class, id);
		} finally {
			session.close();
		}
	}


	@Transactional
	public void save(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	@Transactional
	public void delete(int id) {
		Priority priority = (Priority) sessionFactory.getCurrentSession().get(Priority.class, id);
		sessionFactory.getCurrentSession().delete(priority);
	}

}
