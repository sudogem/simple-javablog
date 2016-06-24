package com.blog.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.form.LoginForm;
import com.blog.form.RegistrationForm;
import com.blog.form.UserProfile;
import com.blog.helper.AdminConsole;

public interface ISecurityManager {

	boolean isAuthenticSession(HttpServletRequest request);

	void catchInvalidSession(HttpServletRequest request);

	void clearSession(HttpSession session);

	void login(LoginForm loginForm, HttpServletRequest request, HttpServletResponse response);

	void setSessionCookie(HttpServletRequest request, HttpServletResponse response);

	boolean authenticate(LoginForm loginForm);

	String securePassword(String password);

	void register(RegistrationForm form);

	boolean isHandleExist(String handle);

	boolean isEmailExist(String email);

	void logout(HttpServletRequest request, HttpServletResponse response);

	void clearCookies(HttpServletResponse response);

	boolean verifyPassword(int userId, String password);

	boolean verifyEmail(int userId, String email);

	boolean isEmailExist(int userId, String email);

	boolean authenticateAdmin(int userId);

	AdminConsole loadAdminConsole();

	UserProfile getUserProfile(int userId);

	void updateUser(UserProfile profile);

	void deleteUser(int userId);

}
