package com.ini.xfn.nmcuong.service;

import java.util.List;


import com.ini.xfn.nmcuong.domain.Project;

public interface ProjectService {
	public List<Project> getAll();
	public Project getById(int id);
}
