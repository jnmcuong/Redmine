package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.IssueDAO;
import com.ini.xfn.nmcuong.domain.Issue;
import com.ini.xfn.nmcuong.domain.Member;

@Repository
public class IssueDAOImpl implements IssueDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// public void setSessionFactory(SessionFactory sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }

	@Transactional
	public List<Issue> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Issue");
		List<Issue> listIssue = query.list();
//		session.close();
		return listIssue;
	}

	public Issue getById(int id) {
		Session session = sessionFactory.openSession();
		try {
			return (Issue) session.get(Issue.class, id);
		} finally {
			session.close();
		}
	}

	public void save(Issue issue) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(issue);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Issue member = (Issue) session.get(Issue.class, id);
		sessionFactory.getCurrentSession().delete(member);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Issue> getParentTask(int idProject, String message) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Issue.class);
		Criterion idCri = Restrictions.eq("project.id", idProject);
		// Criterion termCri = Restrictions.like("subject","%"+message+"%");
		// criteria.add(Restrictions.and(idCri, termCri));
		criteria.add(idCri);
		List<Issue> listIssue = criteria.list();

		session.close();
		return listIssue;
	}

}
