package com.adp.control.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ProjectService;
import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;

public class ProjectAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	ProjectService projectService ;
	
	private float budget ;
	
	private ProjectEntity project ;
	
	private List<ProjectEntity> projects ;
	
	
	
	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public List<ProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}

	public String addProject()  {
		
		return SUCCESS ;
	}
	
	
	
	private Long id ;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String modifyProject() throws ADPException {
		
		
		project = projectService.getProject(id);
		
		
		return SUCCESS ;
	}
	public String viewProjects() throws ADPException {
		
		try {
			projects = projectService.getAllProjects();
		} catch (ADPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS ;
		
	}
	
	public String removeProject() throws ADPException {
		
		ProjectEntity p = projectService.getProject(id);
		String name = p.getProjectName() ;
		projectService.deleteProject(id);
		addActionMessage("the project "+name+" was deleted successefully ! ");
		
		return SUCCESS ;
	}
	
public String detailProject() throws ADPException {
		ProjectEntity p = projectService.getProject(id) ;
		budget= p.getBudget() ;
		
		return SUCCESS ;
	}
	
	
	
	
}
