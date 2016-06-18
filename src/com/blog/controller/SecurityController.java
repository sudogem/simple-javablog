package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.blog.service.ISecurityManager;

public class SecurityController extends MultiActionController {
	
	private ISecurityManager securityManager;
	
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		securityManager.logout(request, response);
		return new ModelAndView("redirect:index.do");
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
