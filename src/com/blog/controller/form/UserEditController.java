package com.blog.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.blog.form.UserProfile;
import com.blog.service.ISecurityManager;
import com.blog.util.RequestUtils;

public class UserEditController extends SimpleFormController {

	private ISecurityManager securityManager;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		UserProfile user = (UserProfile) command;
		securityManager.updateUser(user);
		
		return new ModelAndView("redirect:admin.do");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		int userId = RequestUtils.getParam(request, "id", 0);
		UserProfile userProfile = securityManager.getUserProfile(userId);
		return userProfile;
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
