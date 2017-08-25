package com.adp.business.dao.impl;

import java.util.List;

import com.adp.business.dao.MissionDAO;
import com.adp.entities.MissionEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

public class MissionDAOImpl extends GenericDAOImpl<MissionEntity> implements MissionDAO {

	public MissionEntity addMission(MissionEntity p) throws ADPException {

		return persist(p);
	}

	public MissionEntity getMission(Long idMission) throws ADPException {

		return load(idMission);
	}

	public void updateMission(MissionEntity p) throws ADPException {

		merge(p);

	}

	public void deleteMission(Long idMission) throws ADPException {
		remove(idMission);
	}

	public List<MissionEntity> getAllMissions() throws ADPException {
		return findAll();
	}

	@SuppressWarnings("unchecked")
	public List<MissionEntity> getMissionsByProject(Long projectId) throws ADPException {

		String q = " from MissionEntity m where m.project.id = ? ";
		return getHibernateTemplate().find(q, projectId);

	}

	public MissionEntity getMissionByName(String name) throws ADPException {
		String query = "from MissionEntity where missionName= :x";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x", name);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (MissionEntity) result.get(0);
		} else
			return null;
	}


	

}
