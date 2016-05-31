package com.blog.dao;

import java.util.List;

import com.blog.entity.Blog;
import com.blog.helper.BlogPreview;

public interface IBlogDAO extends IHibernateDAO {

	Blog findLatest(int userId);

	List<BlogPreview> findBlogPreviews(int userId);

	Blog find(int blogId, int userId);

	Blog find(int blogId);

	List<BlogPreview> findLatestBlogs();

}
