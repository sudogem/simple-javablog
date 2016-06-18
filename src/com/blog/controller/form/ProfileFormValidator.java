package com.blog.controller.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.form.UserProfile;
import com.blog.service.ISecurityManager;
import com.blog.util.StringUtils;

@SuppressWarnings("unchecked")
public class ProfileFormValidator implements Validator {
	
	private ISecurityManager securityManager;

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(UserProfile.class);
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserProfile form = (UserProfile) object;
		
		Integer userId = form.getId();
		String oldPassword = form.getOldPassword();
		String newPassword = form.getNewPassword();
		String confirmPassword = form.getConfirmPassword();
		String oldEmail = form.getEmail();
		String newEmail = form.getNewEmail();
		String confirmEmail = form.getConfirmEmail();
		
		if (!StringUtils.isEmpty(newPassword)) {
			if (newPassword.length() < 6)
				errors.reject("error.nullpointer", "New password should not be less than 6 characters.");
			else if (StringUtils.isEmpty(confirmPassword) || !StringUtils.equals(newPassword, confirmPassword))
				errors.reject("error.nullpointer", "The new passwords you entered did not match.");
			else if (StringUtils.isEmpty(oldPassword))
				errors.reject("error.nullpointer", "Please enter your old password");
			else if (!securityManager.verifyPassword(userId, oldPassword))
				errors.reject("error.nullpointer", "The old password you entered is incorrect");
		}
		
		if (!StringUtils.isEmpty(newEmail)) {
			if (StringUtils.isEmpty(oldEmail) || !StringUtils.isEmail(oldEmail) || !StringUtils.isEmail(newEmail))
				errors.reject("error.nullpointer", "Please enter a valid email address.");
			else if (StringUtils.isEmpty(confirmEmail) || !StringUtils.equals(newEmail, confirmEmail))
				errors.reject("error.nullpointer", "The new email you entered did not match.");
			else if (!securityManager.verifyEmail(userId, oldEmail))
				errors.reject("error.nullpointer", "This is not your old email address.");
			else if (securityManager.isEmailExist(userId, newEmail))
    			errors.reject("error.nullpointer", "The new email you entered is already being used.");
		}
		
	}

	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}
	
}
