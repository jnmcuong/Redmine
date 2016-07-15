package com.ini.xfn.nmcuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ini.xfn.nmcuong.dao.TrackerDAO;
import com.ini.xfn.nmcuong.domain.Tracker;
import com.ini.xfn.nmcuong.service.TrackerService;

public class TrackerServiceImpl implements TrackerService {

	@Autowired
	private TrackerDAO trackerDAO;
	

	public List<Tracker> getAll() {
		return trackerDAO.getAll();
	}

	public Tracker getById(int id) {
		return trackerDAO.getById(id);
	}

}
