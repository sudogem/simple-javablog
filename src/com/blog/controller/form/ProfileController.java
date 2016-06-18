package com.blog.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.blog.form.UserProfile;
import com.blog.helper.Key;
import com.blog.service.IProfileManager;

public class ProfileController extends SimpleFormController {
	
	private IProfileManager profileManager;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		int userId = (Integer) request.getSession().getAttribute(Key.USER_ID);
		
		UserProfile profile = (UserProfile) command;
		profileManager.updateProfile(profile, userId);
		
		return new ModelAndView("redirect:userConsole.do");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		int userId = (Integer) request.getSession().getAttribute(Key.USER_ID);
		UserProfile profile = profileManager.getProfile(userId);
		return profile;
	}

	public IProfileManager getProfileManager() {
		return profileManager;
	}

	public void setProfileManager(IProfileManager profileManager) {
		this.profileManager = profileManager;
	}
	
}
