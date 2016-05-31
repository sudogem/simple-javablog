package com.blog.dao.impl;

import java.util.Calendar;
import java.util.List;

import com.blog.dao.IUserDAO;
import com.blog.entity.User;
import com.blog.form.LoginForm;
import com.blog.form.RegistrationForm;
import com.blog.service.ISecurityManager;

@SuppressWarnings("unchecked")
public class UserDAOImpl extends HIbernateDAOImpl implements IUserDAO {
	
	private ISecurityManager securityManager;
	
	public List<User> getAll() {
		return select("FROM User", null);
	}
	
	public User login(LoginForm loginForm) {
		String hql = "FROM User WHERE username = ? AND password = ? AND isActive = true";
		return (User) find(hql, new Object[] {loginForm.getUsername(), loginForm.getPassword()});
	}
	
	public boolean authenticate(LoginForm loginForm) {
		String hql = "SELECT id FROM User WHERE username = ? AND password = ? AND isActive = true";
		Integer userId = (Integer) find(hql, new Object[] {loginForm.getUsername(), loginForm.getPassword()});
		if (userId != null && userId > 0)
			return true;
		return false;
	}
	
	public User findById(int userId) {
		String hql = "FROM User WHERE id = ?";
		return (User) find(hql, new Object[] {userId});
	}
	
	public void register(RegistrationForm form) {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		user.setEmail(form.getEmail());
		user.setDateRegistered(Calendar.getInstance());
		user.setIsActive(true);
		create(user);
	}
	
	public boolean isEmailExist(String email) {
		String hql = "SELECT id FROM User WHERE email = ?";
		Integer userId = (Integer) find(hql, new Object[] {email});
		if (userId != null)
			return true;
		return false;
	}
	
	public boolean isEmailExist(int userId, String email) {
		String hql = "SELECT u.id FROM User u WHERE u.email = ? AND u.id != ?";
		Integer uid = (Integer) find(hql, new Object[] {email, userId});
		if (uid != null)
			return true;
		return false;
	}
	
	public boolean isHandleExist(String handle) {
		String hql = "SELECT u.id FROM User u WHERE u.username = ? OR u.username LIKE ?";
		Integer userId = (Integer) find(hql, new Object[] {handle, handle});
		if (userId != null)
			return true;
		return false;
	}
	
	public boolean verifyEmail(int userId, String email) {
		String hql = "SELECT u.id FROM User u WHERE u.email = ?";
		Integer uid = (Integer) find(hql, new Object[] {email});
		if (uid != null && uid.intValue() == userId)
			return true;
		return false;
	}
	
	public boolean verifyPassword(int userId, String password) {
		String hql = "SELECT u.id FROM User u WHERE u.password = ?";
		Integer uid = (Integer) find(hql, new Object[] {password});
		if (uid != null && uid.intValue() == userId)
			return true;
		return false;
	}
	
	public boolean getIsAdmin(int userId) {
		String hql = "SELECT isAdmin FROM User WHERE id = ?";
		return (Boolean) find(hql, new Object[] {userId});
	}
	
	public ISecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}
	
}
