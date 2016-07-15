package com.ini.xfn.nmcuong.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.ini.xfn.nmcuong.model.IssueModel;

import java.sql.Time;

@Entity
@Table(name="Issues")
public class Issue {
	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="issue_seq", sequenceName="issue_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "issue_seq")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name="project_id", nullable =false)
	private Project project;
	
	@Column(name="subject")
	private String subject;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="add_by", nullable = false)
	private Member memberAdded;
	
	@Column(name="time_create")
	private Date timeCreated;
	
	@Column(name="time_update")
	private Date timeUpdated;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="assignee", nullable = false)
	private Member assignee;
	
	public Member getAssignee() {
		return assignee;
	}

	public void setAssignee(Member assignee) {
		this.assignee = assignee;
	}

	@Column(name="start_d")
//	@Type(type="date")
	private Date startDate;
	
	@Column(name="due_date")
	private Date dueDate;
	
	@Column(name="percent_finish")
	private int percentFinished;
	
	@Column(name="estimated_time")
	private int estimatedTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name="priority", nullable = false)
	private Priority priority;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="status", nullable = false)
//	@Cascade(value = CascadeType.SAVE_UPDATE)
	private Status status;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="category", nullable = false)
//	private Category category;
	
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	@Column(name="target_version")
	private String targetVersion;
	
	@Column(name="spent_time")
	private float spentTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parent_task")
	private Issue parentTask;
	
	

	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tracker_id", nullable = false)
	private Tracker tracker;
	
	
	
//	private List<Member> watchers;

//	public List<Member> getWatchers() {
//		return watchers;
//	}
//
//	public void setWatchers(List<Member> watchers) {
//		this.watchers = watchers;
//	}

	public Issue getParentTask() {
		return parentTask;
	}

	public void setParentTask(Issue parentTask) {
		this.parentTask = parentTask;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Member getUserAdded() {
		return memberAdded;
	}

	public void setUserAdded(Member userAdded) {
		this.memberAdded = userAdded;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

//	public Member getAssignee() {
//		return assignee;
//	}
//
//	public void setAssignee(Member assignee) {
//		this.assignee = assignee;
//	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getPercentFinished() {
		return percentFinished;
	}

	public void setPercentFinished(int percentFinished) {
		this.percentFinished = percentFinished;
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public String getTargetVersion() {
		return targetVersion;
	}

	public void setTargetVersion(String targetVersion) {
		this.targetVersion = targetVersion;
	}

	public float getSpentTime() {
		return spentTime;
	}

	public void setSpentTime(float spentTime) {
		this.spentTime = spentTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tracker getTracker() {
		return tracker;
	}

	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}
	
	public Issue() {
		
	}
	
	public Issue(IssueModel issueModel){
		
		this.tracker = new Tracker();
		this.tracker.setId(issueModel.getTracker());
		
		
		this.subject = issueModel.getSubject();
		this.description = issueModel.getDescription();
		
		this.status = new Status();
		this.status.setId(issueModel.getStatus());
		
		this.priority = new Priority();
		this.priority.setId(issueModel.getPriority());
		
		this.assignee = new Member();
		this.assignee.setId(issueModel.getAssignee());
		
		if (issueModel.getParentIssue() != null) {
			this.parentTask = new Issue();
			this.parentTask.setId(issueModel.getParentIssue());
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		this.startDate = new Date();
		this.dueDate = new Date();
		try {
			this.startDate.setTime((dateFormat.parse(issueModel.getStartDate()).getTime()));
			this.dueDate.setTime((dateFormat.parse(issueModel.getDueDate()).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		this.estimatedTime = issueModel.getEstimatedTime();
		this.percentFinished = issueModel.getPercentFinished();
		
		this.memberAdded = new Member();
		this.memberAdded.setId(issueModel.getMemberAdded());
		
		this.project = new Project();
		this.project.setId(issueModel.getProject());
		
		this.timeCreated = new Date();
		this.timeUpdated = new Date();
	}
}
