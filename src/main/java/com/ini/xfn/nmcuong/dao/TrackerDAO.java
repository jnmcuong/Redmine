package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Tracker;

public interface TrackerDAO {
	public List<Tracker> getAll();
	public Tracker getById(int id);
	public void save(Tracker tracker);
	public void delete(int id);
}
