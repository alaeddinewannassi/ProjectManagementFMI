package com.adp.business.dao;

import java.util.List;

import com.adp.entities.MissionEntity;
import com.adp.exceptions.ADPException;

public interface MissionDAO extends GenericDAO<MissionEntity> {

	public MissionEntity addMission(MissionEntity p) throws ADPException ;
	public MissionEntity getMission(Long idMission) throws ADPException ;
	public void updateMission(MissionEntity p) throws ADPException ;
	public void deleteMission(Long idMission) throws ADPException ;
	List<MissionEntity> getAllMissions()throws ADPException ;
	List<MissionEntity> getMissionsByProject(Long projectId) throws ADPException;
	public MissionEntity getMissionByName(String name)throws ADPException ;
	
	
}
