package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Role;
import com.ini.xfn.nmcuong.domain.User;

public interface RoleDAO {
	public List<Role> getAll();
	public Role getById(int id);
	public void save(Role role);
	public void delete(int id);
}
