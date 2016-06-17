package com.blog.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.blog.form.LoginForm;
import com.blog.service.ISecurityManager;

public class LoginController extends SimpleFormController {

	private ISecurityManager securityManager;
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
			Object command, BindException errors) throws Exception {
		securityManager.login((LoginForm) command, request, response);
		return new ModelAndView("redirect:index.do");
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
