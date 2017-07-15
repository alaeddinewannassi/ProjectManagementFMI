package com.adp.business.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.adp.business.dao.GenericDAO;
import com.adp.entities.AbstractEntity;
import com.adp.exceptions.ADPException;


@Repository(value="genericDAO")
public class GenericDAOImpl<E extends AbstractEntity> extends HibernateDaoSupport implements GenericDAO<E> {

	/**
	 * Entity class
	 */
	protected final Class<E> entityClass;

	/**
	 * Constructor
	 */
	@SuppressWarnings("all")
	public GenericDAOImpl() {
		super();
		this.entityClass = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * {@inheritDoc}
	 */

	public E merge(E sourceETO) throws ADPException {
		E entity = getHibernateTemplate().merge(sourceETO);
		return entity;
	}

	/**
	 * {@inheritEoc}
	 */
	public E persist(E entity) throws ADPException {
		
		if (entity.getId() == null) {
			// new
			getHibernateTemplate().persist(entity);
		} else {
			// update
			getHibernateTemplate().merge(entity);
		}
		return entity;
	}

	/**
	 * {@inheritEoc}
	 */
	public E load(Long entityId) throws ADPException {
		return getHibernateTemplate().get(entityClass, entityId);
		
	}

	/**
	 * {@inheritEoc}
	 */
	public void remove(E entity) throws ADPException {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * {@inheritEoc}
	 */
	public void remove(Long entityId) throws ADPException {
		E entity = load(entityId);
		getHibernateTemplate().delete(entity);
	}

	/**
	 * {@inheritEoc}
	 */
	@SuppressWarnings("all")
	public List<E> findAll() throws ADPException {

		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * {@inheritEoc}
	 */
	public List<E> findByCriteria(String criteria) throws ADPException {
		return null;
	}
	
	public E loadNoSession(Long entityId) throws ADPException {
		E entity = null;
		try {
			entity = (E) getHibernateTemplate()
					.get(entityClass, entityId);
		} 
		catch (Exception e) {
			throw new ADPException("Erreur base des donnees", e);

		}
		return entity;
	}
}
