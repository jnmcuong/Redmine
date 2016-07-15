package com.ini.xfn.nmcuong.dao;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Issue;

public interface IssueDAO {
	public List<Issue> getAll();
	public Issue getById(int id);
	public void save(Issue issue);
	public void delete(int id);
	public List<Issue> getParentTask(int idProject, String message);
}
