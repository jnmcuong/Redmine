package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.User;

public interface UserDAO {
	public List<User> getAll();
	public User getById(int id);
	public void save(User user);
	public void delete(int id);
}
