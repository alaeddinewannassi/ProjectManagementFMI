package com.adp.control.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.MissionService;
import com.adp.business.services.ProjectService;
import com.adp.entities.MissionEntity;
import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;


public class TurnoverAction extends AbstractAction implements ServletContextAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	ProjectService projectService;
	
	@Autowired
	MissionService missionService;
	
	List<String> projectList = new ArrayList<>();

	List<String> missionList = new ArrayList<>();
	
	private String selectedProject;
	
	private String selectedMonth ;
	
	
	public List<String> getProjectList() {
		return projectList;
	}


	public void setProjectList(List<String> projectList) {
		this.projectList = projectList;
	}


	public List<String> getMissionList() {
		return missionList;
	}


	public void setMissionList(List<String> missionList) {
		this.missionList = missionList;
	}


	public String getSelectedProject() {
		return selectedProject;
	}


	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}


	public String getSelectedMonth() {
		return selectedMonth;
	}


	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}


	public String doAddMonth() throws ADPException {

		if(selectedMonth!= null){
		
			List<ProjectEntity> projectsByMonth =  projectService
		 .getProjectsByMonth(Integer.parseInt(selectedMonth));
		 
		 for (ProjectEntity project : projectsByMonth) {
		 projectList.add(project.getProjectName()); }
		
		}
		

		ProjectEntity project = projectService.getProjectByName(selectedProject);
		if (project != null) {
			List<MissionEntity> missions = missionService.getMissionsByProject(project.getId());

			for (MissionEntity m : missions) {
				missionList.add(m.getMissionName());
			}
		
			return SUCCESS;
		
		} else

			return SUCCESS;
	
	}
	
	
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

}
