package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.FileDAO;
import com.ini.xfn.nmcuong.domain.File;
import com.ini.xfn.nmcuong.domain.Tracker;

@Repository
public class FileDAOImpl implements FileDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<File> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from File");
		return query.list();
	}

	@Transactional(readOnly = true)
	public File getById(int id) {
		return (File) sessionFactory.getCurrentSession().get(File.class, id);
	}

	@Transactional
	public void save(File file) {
		sessionFactory.getCurrentSession().saveOrUpdate(file);
	}

	@Transactional
	public void delete(int id) {
		File file = (File) sessionFactory.getCurrentSession().get(File.class, id);
		sessionFactory.getCurrentSession().delete(file);
	}

}
