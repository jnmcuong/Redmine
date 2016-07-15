package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.UserDAO;
import com.ini.xfn.nmcuong.domain.Issue;
import com.ini.xfn.nmcuong.domain.Member;
import com.ini.xfn.nmcuong.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	
	@Transactional
	public List<User> getAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from User");
			return query.list();
		} finally {
			session.close();
		}
	}

	public User getById(int id) {
		Session session = sessionFactory.openSession();
		try {
			return (User) session.get(User.class, id);
		} finally {
			session.close();
		}
	}

	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public void delete(int id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		sessionFactory.getCurrentSession().delete(user);
	}

}
