package com.blog.entity;

import java.io.Serializable;
import java.util.Calendar;

public class Blog implements Serializable {
	private static final long serialVersionUID = 6492675596264121571L;

	private Integer id = -1;
	private String title;
	private String blog;
	private Calendar dateCreated;
	private Calendar dateLastUpdated;
	private User author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public Calendar getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Calendar getDateLastUpdated() {
		return dateLastUpdated;
	}

	public void setDateLastUpdated(Calendar dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
