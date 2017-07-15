package com.adp.control.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.MissionService;
import com.adp.business.services.ProjectService;
import com.adp.entities.MissionEntity;
import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;

public class MissionAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	MissionService missionService ;
	
	@Autowired
	ProjectService projectService ;
	
	
	private MissionEntity mission ;
	
	private List<ProjectEntity> projects ;
	
	
	
	
	
	
	
	public List<ProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectEntity> p) {
		projects = p;
	}

	public MissionEntity getMission() {
		return mission;
	}

	public void setMission(MissionEntity mission) {
		this.mission = mission;
	}

	

	public String addMission() throws ADPException {
		
		projects = projectService.getAllProjects() ;
		
		return SUCCESS ;
	}
	
	private Long id ;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String modifyMission() throws ADPException {
		
		 mission = missionService.getMission(id);
		
		
		return SUCCESS ;
	}
	public String showMissions() throws ADPException {
		
		projects = projectService.getAllProjects() ;
		return SUCCESS ;	
	}
	
	public String removeMission() throws ADPException {
		
		MissionEntity p = missionService.getMission(id);
		String name = p.getMissionName() ;
		missionService.deleteMission(id);
		addActionMessage("the Mission "+name+" was deleted successefully ! ");
		
		return SUCCESS ;
	}
	
	
	
	
}
