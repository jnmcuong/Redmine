package com.ini.xfn.nmcuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ini.xfn.nmcuong.dao.StatusDAO;
import com.ini.xfn.nmcuong.domain.Status;
import com.ini.xfn.nmcuong.service.StatusService;

public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusDAO statusDAO;
	
	public List<Status> getAll() {
		return statusDAO.getAll();
	}

	public Status getById(int id) {
		return statusDAO.getById(id);
	}

}
