package com.blog.service;

import com.blog.form.UserProfile;

public interface IProfileManager {

	UserProfile getProfile(int userId);

	void updateProfile(UserProfile form, int userId);

}
