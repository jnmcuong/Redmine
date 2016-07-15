package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.ProjectDAO;
import com.ini.xfn.nmcuong.domain.Project;
import com.ini.xfn.nmcuong.domain.Tracker;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

		
	@Transactional(readOnly = true)
	public List<Project> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Project");
		session.close();
		return query.list();
	}

	@Transactional(readOnly = true)
	public Project getById(int id) {
		Session session = sessionFactory.openSession();
		Project project = (Project)session.get(Project.class, id);
		session.close();
		return project;
	}

	@Transactional
	public void save(Project project) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(project);
		session.close();
	}

	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Project project = (Project) session.get(Project.class, id);
		session.delete(project);
		session.close();
	}

}
