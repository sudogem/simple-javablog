package com.blog.dao;

import java.util.List;


@SuppressWarnings("unchecked")
public interface IHibernateDAO {
	
	int create(Object object);
	
//	void insert(Object object);
	
	void delete(Object object);
	
	void insertOrUpdate(Object object);
	
	List select(String hql, Object[] params, int maxResults);

	List select(String hql, Object[] params);

	int execute(String hql, Object[] params);

	Object find(String hql, Object[] params);

}
