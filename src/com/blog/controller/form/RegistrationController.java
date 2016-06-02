package com.blog.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.blog.form.RegistrationForm;
import com.blog.service.ISecurityManager;

public class RegistrationController extends SimpleFormController {

	private ISecurityManager securityManager;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
			Object command, BindException errors) throws Exception {
		securityManager.register((RegistrationForm) command);
		return new ModelAndView(".registrationSuccess");
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
