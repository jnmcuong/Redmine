package com.ini.xfn.nmcuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ini.xfn.nmcuong.dao.MemberDAO;
import com.ini.xfn.nmcuong.dao.UserDAO;
import com.ini.xfn.nmcuong.domain.User;
import com.ini.xfn.nmcuong.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public List<User> getAll() {
		return userDAO.getAll();
	}

	public User getById(int id) {
		return userDAO.getById(id);
	}

}
