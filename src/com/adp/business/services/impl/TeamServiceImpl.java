package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.TeamDAO;
import com.adp.business.services.TeamService;
import com.adp.entities.ProjectEntity;
import com.adp.entities.TeamEntity;
import com.adp.exceptions.ADPException;




@Service("TeamService")
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamDAO TeamDAO ;
	
	
	public TeamEntity addTeam(TeamEntity p) throws ADPException {
		return TeamDAO.addTeam(p);
	}

	public TeamEntity getTeam(Long idTeam) throws ADPException {
		return TeamDAO.getTeam(idTeam);
	}

	public void updateTeam(TeamEntity p) throws ADPException {
		TeamDAO.updateTeam(p);
	}

	public void deleteTeam(Long idTeam) throws ADPException {
		TeamDAO.deleteTeam(idTeam);
	}

	public List<TeamEntity> getAllTeams() throws ADPException {
		return TeamDAO.getAllTeams();
	}

	public TeamEntity getTeamByName(String name) throws ADPException {
		// TODO Auto-generated method stub
		return TeamDAO.getTeamByName(name);
	}

	@Override
	public List<TeamEntity> getTeamsByProject(String name) throws ADPException {
		// TODO Auto-generated method stub
		return TeamDAO.getTeamsByProject(name);
	}

	@Override
	public ProjectEntity getProjectByTeam(String name) throws ADPException {
		// TODO Auto-generated method stub
		return TeamDAO.getProjectByTeam(name);
	}

	
}
