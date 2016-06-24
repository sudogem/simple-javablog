package com.blog.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.blog.dao.IUserDAO;
import com.blog.entity.User;
import com.blog.exception.SecurityException;
import com.blog.form.LoginForm;
import com.blog.form.RegistrationForm;
import com.blog.form.UserProfile;
import com.blog.helper.AdminConsole;
import com.blog.helper.Key;
import com.blog.service.ISecurityManager;
import com.blog.util.RequestUtils;
import com.blog.util.StringUtils;

public class SecurityManager implements ISecurityManager {
	
	private static final Logger logger = Logger.getLogger(SecurityManager.class);
	
	private IUserDAO userDAO;
	
	public boolean isAuthenticSession(HttpServletRequest request) {
		Cookie cookie = RequestUtils.getCookie(request, Key.SESSION_COOKIE);
		String userCookie = cookie.getValue();

		HttpSession session = request.getSession();
		String sessionCookie = (String) session.getAttribute(Key.SESSION_COOKIE);

		if (!StringUtils.isEmpty(userCookie) && !StringUtils.isEmpty(sessionCookie)
				&& userCookie.equals(sessionCookie))
			return true;

		return false;
	}
	
	public AdminConsole loadAdminConsole() {
		AdminConsole console = new AdminConsole();
		
		List<User> users = userDAO.getAll();
		console.setUsers(users);
		
		return console;
	}
	
	public void deleteUser(int userId) {
		User user = userDAO.findById(userId);
		if (user != null)
			userDAO.delete(user);
	}
	
	public UserProfile getUserProfile(int userId) {
		User user = userDAO.findById(userId);
		if (user == null)
			throw new SecurityException();
		
		UserProfile profile = new UserProfile();
		profile.setId(user.getId());
		profile.setUsername(user.getUsername());
		profile.setEmail(user.getEmail());
		profile.setOldPassword(user.getPassword());
		profile.setIsAdmin(user.getIsAdmin());
		profile.setIsActive(user.getIsActive());
		
		return profile;
	}
	
	public void updateUser(UserProfile profile) {
		User user = userDAO.findById(profile.getId());
		
		String newPassword = profile.getNewPassword();
		if (!StringUtils.isEmpty(newPassword))
			user.setPassword(newPassword);
		
		user.setIsAdmin(profile.getIsAdmin());
		user.setIsActive(profile.getIsActive());
		
		userDAO.insertOrUpdate(user);
	}
	
	public boolean authenticateAdmin(int userId) {
		return userDAO.getIsAdmin(userId);
	}
	
	public boolean verifyPassword(int userId, String password) {
		return userDAO.verifyPassword(userId, password);
	}
	
	public boolean verifyEmail(int userId, String email) {
		return userDAO.verifyEmail(userId, email);
	}
	
	public boolean isEmailExist(int userId, String email) {
		return userDAO.isEmailExist(userId, email);
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		clearSession(request.getSession());
		clearCookies(response);
	}
	
	public void clearCookies(HttpServletResponse response) {
		RequestUtils.delCookie(response, Key.SESSION_COOKIE);
	}
	
	public void register(RegistrationForm form) {
		userDAO.register(form);
	}
	
	public boolean isEmailExist(String email) {
		return userDAO.isEmailExist(email);
	}
	
	public boolean isHandleExist(String handle) {
		return userDAO.isHandleExist(handle);
	}
	
	public void catchInvalidSession(HttpServletRequest request) {
		clearSession(request.getSession());
	}
	
	public void clearSession(HttpSession session) {
		session.removeAttribute(Key.SESSION_COOKIE);
		session.removeAttribute(Key.USER_ID);
		session.removeAttribute(Key.USER_HANDLE);
		session.removeAttribute(Key.USER_PASSWORD);
	}
	
	public String securePassword(String password) {
		if (StringUtils.isEmpty(password)) {
			logger.error("Password is empty.");
			throw new SecurityException();
		}
		return DigestUtils.md5Hex(password);
	}
	
	public void login(LoginForm loginForm, HttpServletRequest request, HttpServletResponse response) {
		User user = userDAO.login(loginForm);
		if (user == null)
			throw new SecurityException();
		
		request.getSession().setAttribute(Key.IS_ADMIN, user.getIsAdmin());
		request.getSession().setAttribute(Key.USER_ID, user.getId());
		request.getSession().setAttribute(Key.USER_HANDLE, user.getUsername());
		request.getSession().setAttribute(Key.USER_PASSWORD, user.getPassword());
		setSessionCookie(request, response);
	}
	
	public boolean authenticate(LoginForm loginForm) {
		return userDAO.authenticate(loginForm);
	}
	
	public void setSessionCookie(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String handle = (String) session.getAttribute(Key.USER_HANDLE);
		if (StringUtils.isEmpty(handle)) {
			logger.error("Handle not found.");
			throw new SecurityException();
		}
		String password = (String) session.getAttribute(Key.USER_PASSWORD);
		if (StringUtils.isEmpty(password)) {
			logger.error("Password not found.");
			throw new SecurityException();
		}
		
		Integer userId = (Integer) session.getAttribute(Key.USER_ID);
		if (userId == null || userId <= 0) {
			logger.error("Handle not found.");
			throw new SecurityException();
		}
		
		String sessionId = session.getId();
		long timeInMillis = Calendar.getInstance().getTimeInMillis();
		
		StringBuilder hex = new StringBuilder();
		hex.append(StringUtils.filter(sessionId));
		hex.append(StringUtils.filter(handle));
		hex.append(StringUtils.filter(password));
		hex.append(userId);
		hex.append(timeInMillis);
		
		String sha512Hex;
		try {
			sha512Hex = DigestUtils.sha512Hex(hex.toString());
		} catch (Exception e) {
			logger.error("Error encountered with md5 for session cookie.");
			throw new SecurityException();
		}
		session.setAttribute(Key.SESSION_COOKIE, sha512Hex);
		RequestUtils.addCookie(response, Key.SESSION_COOKIE, sha512Hex, -1);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
