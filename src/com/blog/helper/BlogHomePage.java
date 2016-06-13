package com.blog.helper;

import java.util.List;

import com.blog.entity.Blog;

public class BlogHomePage {

	private Integer userId;
	private String username;
	private Blog blogLatest;
	private List<BlogPreview> blogPreviews;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Blog getBlogLatest() {
		return blogLatest;
	}

	public void setBlogLatest(Blog blogLatest) {
		this.blogLatest = blogLatest;
	}

	public List<BlogPreview> getBlogPreviews() {
		return blogPreviews;
	}

	public void setBlogPreviews(List<BlogPreview> blogPreviews) {
		this.blogPreviews = blogPreviews;
	}

}
