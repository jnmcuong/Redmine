package com.ini.xfn.nmcuong.service;

import java.util.List;

import com.ini.xfn.nmcuong.domain.Issue;
import com.ini.xfn.nmcuong.model.IssueModel;
import com.ini.xfn.nmcuong.model.ParentTaskModel;


public interface IssueService {
	public List<IssueModel> getAll();
	public Issue getById(int id);
	public void save(IssueModel issueModel);
	public List<ParentTaskModel> getParentTask(int idProject, String message);
}
