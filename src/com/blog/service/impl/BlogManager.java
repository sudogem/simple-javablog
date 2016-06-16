package com.blog.service.impl;

import java.util.Calendar;
import java.util.List;

import com.blog.dao.IBlogDAO;
import com.blog.dao.IUserDAO;
import com.blog.entity.Blog;
import com.blog.entity.User;
import com.blog.form.NewBlogForm;
import com.blog.helper.BlogHomePage;
import com.blog.helper.BlogPreview;
import com.blog.service.IBlogManager;

public class BlogManager implements IBlogManager {

	private IBlogDAO blogDAO;
	private IUserDAO userDAO;
	
	public BlogHomePage loadHomePage(int userId) {
		User user = userDAO.findById(userId);
		if (user == null)
			return null;
		
		BlogHomePage homePage = new BlogHomePage();
		homePage.setUserId(user.getId());
		homePage.setUsername(user.getUsername());
		
		Blog blogLatest = blogDAO.findLatest(userId);
		homePage.setBlogLatest(blogLatest);
		
		List<BlogPreview> blogPreviews = blogDAO.findBlogPreviews(userId);
		homePage.setBlogPreviews(blogPreviews);
		
		return homePage;
	}
	
	public List<BlogPreview> getLatestBlogs() {
		return blogDAO.findLatestBlogs();
	}
	
	public Blog getBlog(int blogId) {
		return blogDAO.find(blogId);
	}
	
	public Blog getBlog(int blogId, int userId) {
		return blogDAO.find(blogId, userId);
	}
	
	public void deleteBlog(int blogId, int userId) {
		Blog blog = blogDAO.find(blogId, userId);
		blogDAO.delete(blog);
	}
	
	public List<BlogPreview> getBlogPreviews(int userId) {
		return blogDAO.findBlogPreviews(userId);
	}
	
	public void saveBlog(NewBlogForm form, int userId) {
		if (form.getId() != null && form.getId() > 0)
			updateBlog(form, userId);
		else
			saveNewBlog(form, userId);
	}
	
	public void saveNewBlog(NewBlogForm form, int userId) {
		Blog blog = new Blog();
		
		User author = userDAO.findById(userId);
		blog.setAuthor(author);
		
		blog.setTitle(form.getTitle());
		blog.setBlog(form.getBlog());
		blog.setDateCreated(Calendar.getInstance());
		
		blogDAO.create(blog);
	}
	
	public void updateBlog(NewBlogForm form, int userId) {
		Blog blog = blogDAO.find(form.getId(), userId);
		blog.setTitle(form.getTitle());
		blog.setBlog(form.getBlog());
		blog.setDateLastUpdated(Calendar.getInstance());
		
		blogDAO.insertOrUpdate(blog);
	}

	public IBlogDAO getBlogDAO() {
		return blogDAO;
	}

	public void setBlogDAO(IBlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
