package com.ini.xfn.nmcuong.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;

import com.ini.xfn.nmcuong.dao.MemberDAO;
import com.ini.xfn.nmcuong.domain.Member;
import com.ini.xfn.nmcuong.model.MemberModel;
import com.ini.xfn.nmcuong.service.MemberService;

public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberModel> getAll() {
		List<Member> listMember = memberDAO.getAll();
		List<MemberModel> listMemberModel = new ArrayList<MemberModel>();
		for (Member member : listMember) {
			listMemberModel.add(new MemberModel(member));
		}		
		return listMemberModel;
	}

	public Member getById(int id) {
		return memberDAO.getById(id);
	}

	public List<MemberModel> getByProject(int id){
		List<Member> listMember = memberDAO.getByProject(id);
		List<MemberModel> listMemberModel = new ArrayList<MemberModel>();
		for (Member member : listMember) {
			listMemberModel.add(new MemberModel(member));
		}		
		return listMemberModel;
	}
}
