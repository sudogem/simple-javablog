package com.blog.controller.form;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.form.RegistrationForm;
import com.blog.service.ISecurityManager;
import com.blog.util.StringUtils;

@SuppressWarnings("unchecked")
public class RegistrationValidator implements Validator {
	
	private static final Logger logger = Logger.getLogger(RegistrationValidator.class);
	
	private ISecurityManager securityManager;

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(RegistrationForm.class);
	}

	@Override
	public void validate(Object form, Errors errors) {
		RegistrationForm regForm = (RegistrationForm) form;
		String username = regForm.getUsername();
		String password = regForm.getPassword();
		String confirmPassword = regForm.getConfirmPassword();
		String email = regForm.getEmail();
		String confirmEmail = regForm.getConfirmEmail();
		
		if (StringUtils.isEmpty(password))
			errors.reject("error.nullpointer", "Please enter a password.");
		else if (password.length() < 6)
			errors.reject("error.nullpointer", "Password should not be less than 6 characters.");
		else if (StringUtils.isEmpty(confirmPassword) || !StringUtils.equals(password, confirmPassword))
			errors.reject("error.nullpointer", "The passwords you entered did not match.");
		
		if (StringUtils.isEmpty(username))
			errors.reject("error.nullpointer", "Please enter a username.");
		else if (username.length() < 6)
			errors.reject("error.nullpointer", "Username/handle should not be less than 6 characters.");
		else if (securityManager.isHandleExist(username))
			errors.reject("error.nullpointer", "The username you entered is already being used.");
		
		if (StringUtils.isEmpty(email))
			errors.reject("error.nullpointer", "Please enter your email.");
		else if (!StringUtils.isEmail(email))
			errors.reject("error.nullpointer", "Please enter a valid email address.");
		else if (StringUtils.isEmpty(confirmEmail) || !StringUtils.equals(email, confirmEmail))
			errors.reject("error.nullpointer", "The emails you entered did not match.");
		else if (securityManager.isEmailExist(email))
			errors.reject("error.nullpointer", "The email you entered is already being used.");
			
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}
	
}
