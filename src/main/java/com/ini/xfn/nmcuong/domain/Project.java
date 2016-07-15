package com.ini.xfn.nmcuong.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Projects")
public class Project {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parent_p")
	private Project project;
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="project_id")
//	private List<Member> listMember;

//	public List<Member> getListMember() {
//		return listMember;
//	}
//
//	public void setListMember(List<Member> listMember) {
//		this.listMember = listMember;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
