package com.blog.dao;

import java.util.List;

import com.blog.entity.User;
import com.blog.form.LoginForm;
import com.blog.form.RegistrationForm;

public interface IUserDAO extends IHibernateDAO {

	User login(LoginForm loginForm);

	User findById(int userId);

	boolean isEmailExist(String email);

	boolean isHandleExist(String handle);

	void register(RegistrationForm form);

	boolean authenticate(LoginForm loginForm);

	boolean verifyPassword(int userId, String password);

	boolean isEmailExist(int userId, String email);

	boolean verifyEmail(int userId, String email);

	boolean getIsAdmin(int userId);

	List<User> getAll();

}
