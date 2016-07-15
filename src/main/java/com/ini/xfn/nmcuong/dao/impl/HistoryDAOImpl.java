package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.HistoryDAO;
import com.ini.xfn.nmcuong.domain.History;
import com.ini.xfn.nmcuong.domain.Tracker;

@Repository
public class HistoryDAOImpl implements HistoryDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<History> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from History");
		return query.list();
	}

	@Transactional(readOnly = true)
	public History getById(int id) {
		return (History) sessionFactory.getCurrentSession().get(History.class, id);
	}

	@Transactional
	public void save(History history) {
		sessionFactory.getCurrentSession().saveOrUpdate(history);
	}

	@Transactional
	public void delete(int id) {
		History history = (History) sessionFactory.getCurrentSession().get(History.class, id);
		sessionFactory.getCurrentSession().delete(history);
	}

}
