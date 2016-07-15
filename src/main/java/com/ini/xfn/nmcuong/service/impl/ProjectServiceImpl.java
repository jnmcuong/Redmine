package com.ini.xfn.nmcuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ini.xfn.nmcuong.dao.ProjectDAO;
import com.ini.xfn.nmcuong.domain.Project;
import com.ini.xfn.nmcuong.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	public List<Project> getAll() {
		return projectDAO.getAll();
	}

	public Project getById(int id) {
		return projectDAO.getById(id);
	}

}
