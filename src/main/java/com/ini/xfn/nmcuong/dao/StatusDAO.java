package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Status;


public interface StatusDAO {
	public List<Status> getAll();
	public Status getById(int id);
	public void save(Status status);
	public void delete(int id);
}
