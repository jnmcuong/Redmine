package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Project;

public interface ProjectDAO {
	public List<Project> getAll();
	public Project getById(int id);
	public void save(Project project);
	public void delete(int id);
}
