package com.adp.business.dao.impl;

import java.util.List;

import com.adp.business.dao.InterestDAO;
import com.adp.entities.InterestEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

public class InterestDAOImpl extends GenericDAOImpl<InterestEntity> implements InterestDAO {

	@Override
	public Long addInterest(InterestEntity i) throws ADPException {
		persist(i);
		return i.getId();
	}

	@Override
	public InterestEntity getInterest(Long id) throws ADPException {
		// TODO Auto-generated method stub
		return load(id);
	}

	@Override
	public List<InterestEntity> getAllInterests() throws ADPException {
		// TODO Auto-generated method stub
		return findAll();
	}

	@Override
	public InterestEntity getInterestByName(String name) throws ADPException {
		String query = "from InterestEntity where interestName= :x";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x", name);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (InterestEntity) result.get(0);
		} else
			return null;
	}

}
