package com.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.blog.helper.Key;
import com.blog.service.ISecurityManager;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = Logger.getLogger(AdminInterceptor.class);

	private ISecurityManager securityManager;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		int userId = (Integer) request.getSession().getAttribute(Key.USER_ID);
		if (userId > 0 && securityManager.authenticateAdmin(userId))
			return true;
		
		logger.info("Session not authenticated as admin. Redirecting to login.");
		response.sendRedirect("logout.do");
		return false;
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
