package com.ini.xfn.nmcuong.service;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Member;
import com.ini.xfn.nmcuong.model.MemberModel;

public interface MemberService {
	public List<MemberModel> getAll();
	public Member getById(int id);
	public List<MemberModel> getByProject(int id);
}
