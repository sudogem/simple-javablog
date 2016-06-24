package com.blog.service.impl;

import com.blog.dao.IUserDAO;
import com.blog.entity.User;
import com.blog.exception.SecurityException;
import com.blog.form.UserProfile;
import com.blog.service.IProfileManager;
import com.blog.util.StringUtils;

public class ProfileManager implements IProfileManager {

	private IUserDAO userDAO;
	
	public UserProfile getProfile(int userId) {
		User user = userDAO.findById(userId);
		if (user == null)
			throw new SecurityException();
		
		UserProfile profile = new UserProfile();
		profile.setId(user.getId());
		profile.setUsername(user.getUsername());
		profile.setEmail(user.getEmail());
		
		return profile;
	}
	
	public void updateProfile(UserProfile form, int userId) {
		int profileId = form.getId();
		if (profileId != userId)
			return;
		User user = userDAO.findById(userId);
		
		String newEmail = form.getNewEmail();
		String newPassword = form.getNewPassword();
		
		if (!StringUtils.isEmpty(newEmail))
			user.setEmail(newEmail);
		if (!StringUtils.isEmpty(newPassword))
			user.setPassword(newPassword);
		
		userDAO.insertOrUpdate(user);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
