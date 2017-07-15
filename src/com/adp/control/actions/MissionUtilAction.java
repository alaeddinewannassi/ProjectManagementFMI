package com.adp.control.actions;




import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.MissionService;
import com.adp.business.services.ProjectService;
import com.adp.entities.MissionEntity;
import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.StringUtil;

public class MissionUtilAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	@Autowired
	MissionService missionService ;
	
	@Autowired
	ProjectService projectService ;
	
	private List<MissionEntity> missions ;
	
	private String selectedProject ;
	
	private String missionName ;

	private float budget ;
	
	private String description ;
	
	private Long id ;
	
	
	
	
	


	public List<MissionEntity> getMissions() {
		return missions;
	}

	public void setMissions(List<MissionEntity> missions) {
		this.missions = missions;
	}

	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMissionName() {
		return missionName;
	}

	public void setMissionName(String MissionName) {
		this.missionName = MissionName;
	}

	

	public MissionUtilAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	

	public String saveMission() throws ADPException {
		
		try {
		if (!check()) {
			addActionError("verify mission fields (*)!");
			return "addMission" ;
		}
		 	ProjectEntity p = projectService.getProjectByName(selectedProject);
			MissionEntity m = new MissionEntity(missionName, budget, description);
			m.setProject(p);
				
				
				Collection<MissionEntity> missions = p.getMissions() ;
				missions.add(m);
				p.setMissions(missions);
				
				missionService.addMission(m);
				projectService.updateProject(p);
				
			
			addActionMessage("the Mission "+missionName+" was added successefully ! ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return SUCCESS ;
	}
	
	public String viewMissions() throws ADPException{
		try {
			ProjectEntity p = projectService.getProjectByName(selectedProject);
			missions = missionService.getMissionsByProject(p.getId());
			
		} catch (ADPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS ;
	
	}
	
	public String updateMission() throws ADPException {
		
	
		MissionEntity m = missionService.getMission(id);
		m.setBudget(budget);
		m.setDescription(description);
		m.setMissionName(missionName);
		
		missionService.updateMission(m);
		
		addActionMessage("the Mission "+missionName+" was updated successefully ! ");
		
		return SUCCESS ;
	}
	


	
	private boolean check() {
		if(StringUtil.isEmpty(missionName) ||StringUtil.isEmpty(description) || budget==0 ){
			return false;
		}
		
		return true;
	}
	
	
	
}
