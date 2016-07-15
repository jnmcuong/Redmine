package com.ini.xfn.nmcuong.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ini.xfn.nmcuong.domain.Issue;

public class IssueModel {
	
	private Integer tracker;
	private String nameTracker;
	private String subject;
	private String description;
	private Integer status;
	private String nameStatus;
	private Integer priority;
	private String namePriority;
	private Integer assignee;
	private String nameAssignee;
	private Integer category;
	private String nameCategory;
	private Integer parentIssue;
	private String startDate;
	private String dueDate;
	private Integer memberAdded;
	private Integer project;
	private Integer id;
	private Integer percentFinished;
	private Float spentTime;
	
		
	/**
	 * is hour value
	 */
	private Integer estimatedTime;
	
	private String timeCreate;
	private String timeUpdated;




	public String getTimeCreate() {
    return timeCreate;
  }
  public void setTimeCreate(String timeCreate) {
    this.timeCreate = timeCreate;
  }
  public String getTimeUpdated() {
    return timeUpdated;
  }
  public void setTimeUpdated(String timeUpdated) {
    this.timeUpdated = timeUpdated;
  }
  public Float getSpentTime() {
    return spentTime;
  }
  public void setSpentTime(Float spentTime) {
    this.spentTime = spentTime;
  }
  public String getNameTracker() {
    return nameTracker;
  }
  public void setNameTracker(String nameTracker) {
    this.nameTracker = nameTracker;
  }
  public String getNameStatus() {
    return nameStatus;
  }
  public void setNameStatus(String nameStatus) {
    this.nameStatus = nameStatus;
  }
  public String getNamePriority() {
    return namePriority;
  }
  public void setNamePriority(String namePriority) {
    this.namePriority = namePriority;
  }
  public String getNameAssignee() {
    return nameAssignee;
  }
  public void setNameAssignee(String nameAssignee) {
    this.nameAssignee = nameAssignee;
  }
  public String getNameCategory() {
    return nameCategory;
  }
  public void setNameCategory(String nameCategory) {
    this.nameCategory = nameCategory;
  }
  public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProject() {
		return project;
	}
	public void setProject(Integer project) {
		this.project = project;
	}
	public Integer getMemberAdded() {
		return memberAdded;
	}
	public void setMemberAdded(Integer memberAdded) {
		this.memberAdded = memberAdded;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getEstimatedTime() {
		return estimatedTime;
	}
	
	/**
	 * is hour value
	 * @param estimatedTime
	 */
	public void setEstimatedTime(Integer estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public Integer getPercentFinished() {
		return percentFinished;
	}
	public void setPercentFinished(Integer percentFinished) {
		this.percentFinished = percentFinished;
	}
	public Integer getParentIssue() {
		return parentIssue;
	}
	public void setParentIssue(Integer parentIssue) {
		this.parentIssue = parentIssue;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public int getAssignee() {
		return assignee;
	}
	public void setAssignee(Integer assignee) {
		this.assignee = assignee;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTracker() {
		return tracker;
	}
	public void setTracker(Integer tracker) {
		this.tracker = tracker;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public IssueModel(){
		
	}
	
	public IssueModel(Issue issue){
		this.id = issue.getId();
		this.nameTracker = issue.getTracker().getName();
		this.subject = issue.getSubject();
		this.description = issue.getDescription();
		this.nameStatus = issue.getStatus().getName();
		this.namePriority = issue.getPriority().getName();
		this.assignee = issue.getAssignee().getUser().getId();
		this.nameAssignee = issue.getAssignee().getUser().getFirstName()
		    + issue.getAssignee().getUser().getLastName();
		this.category = 0;
//		this.parentIssue = issue.getParentTask().getId();
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		this.startDate = df.format(issue.getStartDate());
		this.dueDate = df.format(issue.getDueDate());	
		this.estimatedTime = issue.getEstimatedTime();
		this.percentFinished = issue.getPercentFinished();
		this.spentTime = issue.getSpentTime();
		
		df = new SimpleDateFormat("MM-dd-yyyy hh:mm aaa");
		if (issue.getTimeCreated() != null)
		  this.timeUpdated = df.format(issue.getTimeUpdated());
	}
}
