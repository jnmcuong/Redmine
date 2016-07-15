package com.ini.xfn.nmcuong.service;

import java.util.List;

import com.ini.xfn.nmcuong.domain.User;

public interface UserService {
	public List<User> getAll();
	public User getById(int id);
}
