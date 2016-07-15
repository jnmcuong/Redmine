package com.ini.xfn.nmcuong.model;

import com.ini.xfn.nmcuong.domain.Issue;

public class ParentTaskModel {
	private int id;
	private String label;
	private int value;
	
	public ParentTaskModel(){
		
	}
	
	public ParentTaskModel(Issue issue){
		this.id = issue.getId();
		this.label = issue.getSubject();
		this.value = issue.getId();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
