package com.ini.xfn.nmcuong.model;

import com.ini.xfn.nmcuong.domain.Member;

public class MemberModel {
	
	public MemberModel(Member member){
		this.id = member.getId();
		this.firstName = member.getUser().getFirstName();
		this.lastName = member.getUser().getLastName();
		this.fullName = this.firstName + " " + this.lastName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private int id;
	private String firstName;
	private String lastName;
	private String fullName;
}
