package com.blog.controller.form;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.form.LoginForm;
import com.blog.service.ISecurityManager;
import com.blog.util.StringUtils;

@SuppressWarnings("unchecked")
public class LoginValidator implements Validator {
	
	private static final Logger logger = Logger.getLogger(LoginValidator.class);

	private ISecurityManager securityManager;

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(LoginForm.class);
	}

	@Override
	public void validate(Object form, Errors errors) {
		LoginForm loginForm = (LoginForm) form;
		String handle = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if (StringUtils.isEmpty(handle))
			errors.reject("error.nullpointer", "Please enter your username.");
		if (StringUtils.isEmpty(password))
			errors.reject("error.nullpointer", "Please enter your password.");
		
		if (!StringUtils.isEmpty(handle) && !StringUtils.isEmpty(password))
			if (!securityManager.authenticate(loginForm))
				errors.reject("error.nullpointer", "Invalid username/password.");
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
