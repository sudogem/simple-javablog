package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.blog.helper.AdminConsole;
import com.blog.service.ISecurityManager;
import com.blog.util.RequestUtils;

public class AdminController extends MultiActionController {

	private ISecurityManager securityManager;
	
	public ModelAndView admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminConsole adminConsole = securityManager.loadAdminConsole();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(".adminConsole");
		mv.addObject("adminConsole", adminConsole);
		
		return mv;
	}
	
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int userId = RequestUtils.getParam(request, "id", 0);
		securityManager.deleteUser(userId);
		
		return new ModelAndView("redirect:admin.do");
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
