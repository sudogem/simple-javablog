package com.blog.service;

import java.util.List;

import com.blog.entity.Blog;
import com.blog.form.NewBlogForm;
import com.blog.helper.BlogHomePage;
import com.blog.helper.BlogPreview;

public interface IBlogManager {

	BlogHomePage loadHomePage(int userId);

	void saveBlog(NewBlogForm form, int userId);

	List<BlogPreview> getBlogPreviews(int userId);

	Blog getBlog(int blogId, int userId);

	void saveNewBlog(NewBlogForm form, int userId);

	void updateBlog(NewBlogForm form, int userId);

	void deleteBlog(int blogId, int userId);

	Blog getBlog(int blogId);

	List<BlogPreview> getLatestBlogs();

}
