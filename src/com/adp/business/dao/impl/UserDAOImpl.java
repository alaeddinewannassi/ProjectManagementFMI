/**
 * 
 */
package com.adp.business.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.adp.business.dao.UserDAO;
import com.adp.entities.UserEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

/**
 * @author M.BENAMOR
 *
 */

public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements UserDAO {

	public Long addUser(UserEntity u) throws ADPException {
		persist(u);
		return u.getId();
	}

	public UserEntity getUser(String email, String password) throws ADPException {

		String query = "from UserEntity where mail = :mail and password = :password";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, new String[] { "mail", "password" },
				new String[] { email, password });

		if (CollectionsUtil.isNotEmpty(result)) {
			return (UserEntity) result.get(0);
		} else
			return null;
	}

	public UserEntity getUserByToken(String token) throws ADPException {

		String query = "from UserEntity where confirmationToken= :x";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x", token);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (UserEntity) result.get(0);
		} else
			return null;
	}

	public UserEntity updateUser(UserEntity u) throws ADPException {
		return persist(u);
	}

	public boolean userExistsinDB(final String email) throws ADPException {

		Long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) {
				Query query = session.createQuery("select count(*) from UserEntity u where u.mail= :x");
				query.setParameter("x", email);
				return (Long) query.uniqueResult();

			}
		});

		if (count > 0) {
			return true;
		}
		return false;

	}

	public UserEntity getUserByMail(String mail) throws ADPException {

		String query = "from UserEntity where mail = :mail ";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "mail", mail);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (UserEntity) result.get(0);
		} else
			return null;

	}
}
