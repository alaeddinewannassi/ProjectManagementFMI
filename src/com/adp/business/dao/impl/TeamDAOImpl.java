package com.adp.business.dao.impl;

import java.util.List;

import com.adp.business.dao.TeamDAO;
import com.adp.entities.TeamEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

public class TeamDAOImpl extends GenericDAOImpl<TeamEntity> implements TeamDAO {

	public TeamEntity addTeam(TeamEntity p) throws ADPException {
		
		return persist(p);
	}

	public TeamEntity getTeam(Long idTeam) throws ADPException {
		
		return load(idTeam);
	}

	public void updateTeam(TeamEntity p) throws ADPException {
		
		merge(p);
		
	}

	public void deleteTeam(Long idTeam) throws ADPException {
		remove(idTeam);
	}

	public List<TeamEntity> getAllTeams() throws ADPException {
		return findAll();
	}

	public TeamEntity getTeamByName(String name) throws ADPException {
String query = "from TeamEntity where teamName= :x";
		
		
        @SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x",name);

		if(CollectionsUtil.isNotEmpty(result)) {
			return (TeamEntity)result.get(0);
		}
		else return null;
	}


	
	
	
}
