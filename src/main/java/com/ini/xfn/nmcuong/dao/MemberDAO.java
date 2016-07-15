package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Member;



public interface MemberDAO {
	public List<Member> getAll();
	public Member getById(int id);
	public void save(Member member);
	public void delete(int id);
	public List<Member> getByProject(int id);
}
