package com.blog.controller.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.form.UserProfile;
import com.blog.util.StringUtils;

@SuppressWarnings("unchecked")
public class UserEditValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(UserProfile.class);
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserProfile form = (UserProfile) object;
		
		String oldPassword = form.getOldPassword();
		String newPassword = form.getNewPassword();
		String confirmPassword = form.getConfirmPassword();
		
		if (!StringUtils.isEmpty(newPassword)) {
			if (newPassword.length() < 6)
				errors.reject("error.nullpointer", "New password should not be less than 6 characters.");
			else if (StringUtils.isEmpty(confirmPassword) || !StringUtils.equals(newPassword, confirmPassword))
				errors.reject("error.nullpointer", "The new passwords you entered did not match.");
			else if (StringUtils.isEmpty(oldPassword))
				errors.reject("error.nullpointer", "Please enter your old password");
		}
		
	}

}
