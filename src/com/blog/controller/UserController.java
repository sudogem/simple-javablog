package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.blog.helper.BlogHomePage;
import com.blog.helper.Key;
import com.blog.service.IBlogManager;
import com.blog.util.RequestUtils;

public class UserController extends MultiActionController {
	
	private IBlogManager blogManager;
	
	public ModelAndView userHome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userId = RequestUtils.getParam(request, "id", 0);
		if (userId <= 0)
			return new ModelAndView("redirect:index.do");
		
		Object obj = request.getSession().getAttribute(Key.USER_ID);
		int ownerId = 0;
		if (obj != null)
			ownerId = (Integer) obj;
		
		BlogHomePage homePage = blogManager.loadHomePage(userId);
		if (homePage == null)
			return new ModelAndView("redirect:index.do");
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(".userHome");
		mv.addObject("homePage", homePage);
		mv.addObject("isSelf", userId == ownerId);
		
		return mv;
	}

	public IBlogManager getBlogManager() {
		return blogManager;
	}

	public void setBlogManager(IBlogManager blogManager) {
		this.blogManager = blogManager;
	}
	
}
