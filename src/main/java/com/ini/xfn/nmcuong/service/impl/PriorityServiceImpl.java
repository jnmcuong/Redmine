package com.ini.xfn.nmcuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ini.xfn.nmcuong.dao.PriorityDAO;
import com.ini.xfn.nmcuong.domain.Priority;
import com.ini.xfn.nmcuong.service.PriorityService;

@Service
public class PriorityServiceImpl implements PriorityService {

	@Autowired
	private PriorityDAO priorityDAO;
	
	

	@Transactional
	public List<Priority> getAll() {
		return this.priorityDAO.getAll();
	}

	@Transactional
	public Priority getById(int id) {
		return priorityDAO.getById(id);
	}

}
