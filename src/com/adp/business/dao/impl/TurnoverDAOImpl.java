package com.adp.business.dao.impl;

import java.util.List;

import com.adp.business.dao.TurnoverDAO;
import com.adp.entities.MissionEntity;
import com.adp.entities.TurnoverEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

public class TurnoverDAOImpl extends GenericDAOImpl<TurnoverEntity> implements TurnoverDAO {

	@Override
	public TurnoverEntity getTurnover(MissionEntity m) throws ADPException {
		String query = "from TurnoverEntity where mission = :x ";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x", m);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (TurnoverEntity) result.get(0);
		} else
			return null;
	}

	@Override
	public TurnoverEntity addTurnover(TurnoverEntity p) throws ADPException {
		return persist(p);
	}

	@Override
	public TurnoverEntity getTurnover(Long id) throws ADPException {
		return load(id);
	}

	@Override
	public void updateTurnover(TurnoverEntity p) throws ADPException {
		merge(p);
	}

	@Override
	public void deleteTurnover(Long id) throws ADPException {
		remove(id);
	}

	@Override
	public List<TurnoverEntity> getAllTurnovers() throws ADPException {
		return findAll();
	}

}
