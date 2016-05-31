package com.blog.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.blog.dao.IBlogDAO;
import com.blog.entity.Blog;
import com.blog.helper.BlogPreview;

@SuppressWarnings("unchecked")
public class BlogDAOImpl extends HIbernateDAOImpl implements IBlogDAO {
	
	private static final int MAX_PREVIEW = 10;
	
	public Blog findLatest(int userId) {
		String hql = "FROM Blog WHERE author.id = ? ORDER BY dateCreated DESC";
		List<Blog> latestBlog = select(hql, new Object[] {userId}, 1);
		if (latestBlog.size() <= 0)
			return null;
		return latestBlog.get(0);
	}
	
	public List<BlogPreview> findBlogPreviews(int userId) {
		String hql = "SELECT id, title, dateCreated FROM Blog WHERE author.id = ? ORDER BY dateCreated DESC";
		List<Object[]> list = select(hql, new Object[] {userId}, MAX_PREVIEW);
		
		List<BlogPreview> blogPreviews = new ArrayList<BlogPreview>(MAX_PREVIEW);
		for (Object[] obj : list) {
			BlogPreview preview = new BlogPreview();
			preview.setBlogId((Integer) obj[0]);
			preview.setTitle((String) obj[1]);
			preview.setDateCreated(((Calendar) obj[2]).getTime());
			blogPreviews.add(preview);
		}
		
		return blogPreviews;
	}
	
	public List<BlogPreview> findLatestBlogs() {
		String hql = "SELECT b.id, b.title, b.dateCreated, b.author.username, b.author.id FROM Blog b ORDER BY b.dateCreated DESC";
		List<Object[]> list = select(hql, null, MAX_PREVIEW);
		
		List<BlogPreview> blogPreviews = new ArrayList<BlogPreview>(MAX_PREVIEW);
		for (Object[] obj : list) {
			BlogPreview preview = new BlogPreview();
			preview.setBlogId((Integer) obj[0]);
			preview.setTitle((String) obj[1]);
			preview.setDateCreated(((Calendar) obj[2]).getTime());
			preview.setAuthor((String) obj[3]);
			preview.setAuthorId((Integer) obj[4]);
			blogPreviews.add(preview);
		}
		
		return blogPreviews;
	}
	
	public Blog find(int blogId) {
		String hql = "FROM Blog WHERE id = ?";
		return (Blog) find(hql, new Object[] {blogId});
	}
	
	public Blog find(int blogId, int userId) {
		String hql = "FROM Blog WHERE id = ? AND author.id = ?";
		return (Blog) find(hql, new Object[] {blogId, userId});
	}

}
