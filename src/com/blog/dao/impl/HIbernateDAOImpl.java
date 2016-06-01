package com.blog.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.dao.IHibernateDAO;
import com.blog.exception.DaoException;

@SuppressWarnings("unchecked")
public class HIbernateDAOImpl extends HibernateDaoSupport implements IHibernateDAO {
	
	private static final Logger logger = Logger.getLogger(HIbernateDAOImpl.class);
	
	@Override
	public int create(Object object) {
		try {
			return (Integer) getHibernateTemplate().save(object);
		} catch (DataAccessException e) {
			logger.error(e);
			throw new DaoException(e);
		}
	}

	@Override
	public void delete(Object object) {
		try {
			getHibernateTemplate().delete(object);
		} catch (DataAccessException e) {
			logger.error(e);
			throw new DaoException(e);
		}
	}

	@Override
	public void insertOrUpdate(Object object) {
		try {
			getHibernateTemplate().saveOrUpdate(object);
		} catch (DataAccessException e) {
			logger.error(e);
			throw new DaoException(e);
		}
	}
	
	public List select(final String hql, final Object[] params) {
		return select(hql, params, 0);
	}

	@Override
	public List select(final String hql, final Object[] params, final int maxResults) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (params != null) {
					int len = params.length;
					for (int i = 0; i < len; i++) {
						query.setParameter(i, params[i]);
					}
				}
				if (maxResults > 0)
					query.setMaxResults(maxResults);
				
				return query.list();
			}
		});
	}
	
	public int execute(final String hql, final Object[] params) {
		return (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (params != null) {
					int len = params.length;
					for (int i = 0; i < len; i++) {
						query.setParameter(i, params[i]);
					}
				}
				return query.executeUpdate();
			}
		});
	}
	
	public Object find(final String hql, final Object[] params) {
		return getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (params != null) {
					int len = params.length;
					for (int i = 0; i < len; i++) {
						query.setParameter(i, params[i]);
					}
				}
				return query.uniqueResult();
			}
		});
	}

}
