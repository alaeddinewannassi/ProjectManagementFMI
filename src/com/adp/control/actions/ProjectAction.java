package com.adp.control.actions;


import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ProjectService;
import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;

public class ProjectAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	ProjectService projectService;

	private ProjectEntity project;

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public String addProject() {

		return SUCCESS;
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String modifyProject() throws ADPException {

		project = projectService.getProject(id);

		return SUCCESS;
	}

	public String viewProjects() throws ADPException {

		return SUCCESS;

	}

	public String removeProject() throws ADPException {

		ProjectEntity p = projectService.getProject(id);
		String name = p.getProjectName();
		projectService.deleteProject(id);
		addActionMessage("the project " + name + " was deleted successefully ! ");

		return SUCCESS;
	}

	public String detailProject() throws ADPException {
		project = projectService.getProject(id);

		return SUCCESS;
	}

}
