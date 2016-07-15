package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.CategoryDAO;
import com.ini.xfn.nmcuong.domain.Category;
import com.ini.xfn.nmcuong.domain.Tracker;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<Category> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Category");
		return query.list();
	}

	@Transactional(readOnly = true)
	public Category getById(int id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Transactional
	public void save(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	@Transactional
	public void delete(int id) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
		sessionFactory.getCurrentSession().delete(category);
	}

}
