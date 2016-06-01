package com.blog.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.blog.entity.Blog;
import com.blog.helper.BlogPreview;
import com.blog.helper.Key;
import com.blog.service.IBlogManager;
import com.blog.util.RequestUtils;

public class BlogController extends MultiActionController {

	private IBlogManager blogManager;

	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(".home");
		
		List<BlogPreview> latestBlogs = blogManager.getLatestBlogs();
		mv.addObject("latestBlogs", latestBlogs);
		
		return mv;
	}
	
	public ModelAndView userConsole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userId = (Integer) request.getSession().getAttribute(Key.USER_ID);
		List<BlogPreview> blogPreviews = blogManager.getBlogPreviews(userId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(".userConsole");
		mv.addObject("blogPreviews", blogPreviews);
		
		return mv;
	}
	
	public ModelAndView deleteBlog(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userId = (Integer) request.getSession().getAttribute(Key.USER_ID);
		int blogId = RequestUtils.getParam(request, "blog_id", 0);
		
		blogManager.deleteBlog(blogId, userId);
		return new ModelAndView("redirect:userConsole.do");
	}
	
	public ModelAndView blog(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int blogId = RequestUtils.getParam(request, "id", 0);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(".viewBlog");
		
		Blog blog = blogManager.getBlog(blogId);
		if (blog == null)
			return new ModelAndView("redirect:index.do");
		
		mv.addObject("blog", blog);
		mv.addObject("dateCreated", blog.getDateCreated().getTime());
		
		Calendar dateLastUpdated = blog.getDateLastUpdated();
		if (dateLastUpdated != null)
			mv.addObject("dateLastUpdated", dateLastUpdated.getTime());
		
		return mv;
	}
	
	public IBlogManager getBlogManager() {
		return blogManager;
	}

	public void setBlogManager(IBlogManager blogManager) {
		this.blogManager = blogManager;
	}

}
