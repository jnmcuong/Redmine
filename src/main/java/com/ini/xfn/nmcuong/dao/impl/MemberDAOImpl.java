package com.ini.xfn.nmcuong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.MemberDAO;
import com.ini.xfn.nmcuong.domain.Issue;
import com.ini.xfn.nmcuong.domain.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	@Transactional(readOnly = true)
	public List<Member> getAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Member");
			return query.list();
		} finally {
			session.close();
		}
	}

	@Transactional(readOnly = true)
	public Member getById(int id) {
		Session session = sessionFactory.openSession();
		try {
			return (Member) session.get(Member.class, id);
		} finally {
			session.close();
		}
	}

	@Transactional
	public void save(Member member) {
		sessionFactory.getCurrentSession().saveOrUpdate(member);
	}

	@Transactional
	public void delete(int id) {
		Member member = (Member) sessionFactory.getCurrentSession().get(Member.class, id);
		sessionFactory.getCurrentSession().delete(member);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Member> getByProject(int id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Member.class);
		criteria.add(Restrictions.eq("project.id",id));
		List<Member> listMember = criteria.list();
		return listMember;
	}

}
