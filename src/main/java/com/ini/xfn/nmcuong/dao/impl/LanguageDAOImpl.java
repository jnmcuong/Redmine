package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.LanguageDAO;
import com.ini.xfn.nmcuong.domain.Language;
import com.ini.xfn.nmcuong.domain.Tracker;

@Repository
public class LanguageDAOImpl implements LanguageDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<Language> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Language");
		return query.list();
	}

	@Transactional(readOnly = true)
	public Language getById(int id) {
		return (Language) sessionFactory.getCurrentSession().get(Language.class, id);
	}

	@Transactional
	public void save(Language language) {
		sessionFactory.getCurrentSession().saveOrUpdate(language);
	}

	@Transactional
	public void delete(int id) {
		Language language = (Language) sessionFactory.getCurrentSession().get(Language.class, id);
		sessionFactory.getCurrentSession().delete(language);
	}

}
