package com.ini.xfn.nmcuong.domain;

import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="account")
	private String account;
	
	@Column(name="password")
	private String password;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="language")
	private Language language;
	
	@Column(name="NOTIFICATION_TYPE")
	private String typeNotification;
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getTypeNotification() {
		return typeNotification;
	}

	public void setTypeNotification(String typeNofification) {
		this.typeNotification = typeNofification;
	}

	public String getIsNotificationOfMyAction() {
		return notificationOfMyAction;
	}

	public void setNotificationOfMyAction(String notificationOfMyAction) {
		this.notificationOfMyAction = notificationOfMyAction;
	}

	@Column(name="notificationOfMyChange")
	private String notificationOfMyAction;
	
	@Column(name="hide_mail")
	private String isHideMail;
	
	@Column(name="time_zone")
	private TimeZone timeZone;
	
	@Column(name="display_comment")
	private String comment;
	
	@Column(name="warning")
	private String warning;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsHideMail() {
		return isHideMail;
	}

	public void setHideMail(String isHideMail) {
		this.isHideMail = isHideMail;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}
}
