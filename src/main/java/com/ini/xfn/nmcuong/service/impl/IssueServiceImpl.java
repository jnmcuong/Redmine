package com.ini.xfn.nmcuong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ini.xfn.nmcuong.dao.IssueDAO;
import com.ini.xfn.nmcuong.dao.impl.IssueDAOImpl;
import com.ini.xfn.nmcuong.domain.Issue;
import com.ini.xfn.nmcuong.model.IssueModel;
import com.ini.xfn.nmcuong.model.ParentTaskModel;
import com.ini.xfn.nmcuong.service.IssueService;

public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueDAO issueDAO;
	
	public List<IssueModel> getAll() {
		List<IssueModel> listIssueModels = new ArrayList<IssueModel>();
		List<Issue> listIssue = issueDAO.getAll();
		for (Issue issue : listIssue){
			listIssueModels.add(new IssueModel(issue));
		}
		return listIssueModels;
	}

	public Issue getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ParentTaskModel> getParentTask(int idProject, String message){
		List<ParentTaskModel> listParentTask = new ArrayList<ParentTaskModel>();
		List<Issue> listIssue = issueDAO.getParentTask(idProject, message);
		for (Issue issue : listIssue){
			listParentTask.add(new ParentTaskModel(issue));
		}
		return listParentTask;
	}

	
	public void save(IssueModel issueModel) {
		issueDAO.save(new Issue(issueModel));
	}
	
}
