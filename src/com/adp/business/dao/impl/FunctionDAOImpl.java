package com.adp.business.dao.impl;

import java.util.List;

import com.adp.business.dao.FunctionDAO;
import com.adp.entities.FunctionEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

public class FunctionDAOImpl extends GenericDAOImpl<FunctionEntity> implements FunctionDAO {

	public FunctionEntity addFunction(FunctionEntity p) throws ADPException {

		return persist(p);
	}

	public FunctionEntity getFunction(Long idFunction) throws ADPException {

		return load(idFunction);
	}

	public void updateFunction(FunctionEntity p) throws ADPException {

		merge(p);

	}

	public void deleteFunction(Long idFunction) throws ADPException {
		remove(idFunction);
	}

	public List<FunctionEntity> getAllFunctions() throws ADPException {
		return findAll();
	}

	@SuppressWarnings("unchecked")
	public List<FunctionEntity> getFunctionsByMission(Long missionId) throws ADPException {
		String q = " from FunctionEntity f where f.mission.id = ? ";
		return getHibernateTemplate().find(q, missionId);
	}

	@Override
	public FunctionEntity getFunctionsByName(String functionName) throws ADPException {
		String query = "from FunctionEntity where functionName= :x";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x", functionName);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (FunctionEntity) result.get(0);
		} else
			return null;
	}

}
