package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.MissionDAO;
import com.adp.business.services.MissionService;
import com.adp.entities.MissionEntity;
import com.adp.exceptions.ADPException;




@Service("missionService")
public class MissionServiceImpl implements MissionService{

	@Autowired
	MissionDAO MissionDAO ;
	
	
	public MissionEntity addMission(MissionEntity p) throws ADPException {
		return MissionDAO.addMission(p);
	}

	public MissionEntity getMission(Long idMission) throws ADPException {
		return MissionDAO.getMission(idMission);
	}

	public void updateMission(MissionEntity p) throws ADPException {
		MissionDAO.updateMission(p);
	}

	public void deleteMission(Long idMission) throws ADPException {
		MissionDAO.deleteMission(idMission);
	}

	public List<MissionEntity> getAllMissions() throws ADPException {
		return MissionDAO.getAllMissions();
	}

	public List<MissionEntity> getMissionsByProject(Long projectId) throws ADPException {
		// TODO Auto-generated method stub
		return MissionDAO.getMissionsByProject(projectId);
	}

	public MissionEntity getMissionByName(String name) throws ADPException {
		// TODO Auto-generated method stub
		return MissionDAO.getMissionByName(name);	
		}



}
