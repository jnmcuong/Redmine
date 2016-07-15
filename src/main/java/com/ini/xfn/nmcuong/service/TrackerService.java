package com.ini.xfn.nmcuong.service;

import java.util.List;


import com.ini.xfn.nmcuong.domain.Tracker;

public interface TrackerService {
	public List<Tracker> getAll();
	public Tracker getById(int id);
}
