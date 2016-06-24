package com.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.blog.service.ISecurityManager;

public class UserInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = Logger.getLogger(UserInterceptor.class);
	
	private ISecurityManager securityManager;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		boolean isAuthentic = securityManager.isAuthenticSession(request);
		if (isAuthentic) {
			securityManager.setSessionCookie(request, response);
			return true;
		}
		securityManager.catchInvalidSession(request);
		logger.info("Session not authenticated. Redirecting to login.");
		response.sendRedirect("login.do");
		return false;
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
