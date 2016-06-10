package com.blog.entity;

import java.io.Serializable;
import java.util.Calendar;

public class User implements Serializable {
	private static final long serialVersionUID = 8091197205740959431L;

	private Integer id = -1;
	private Boolean isAdmin = false;
	private String username;
	private String password;
	private String email;
	private Calendar dateRegistered;
	private Boolean isActive = true;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Calendar dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
