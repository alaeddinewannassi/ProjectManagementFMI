package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.ProjectDAO;
import com.adp.business.services.ProjectService;
import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;




@Service("projectService")
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectDAO projectDAO ;
	
	
	@Override
	public List<ProjectEntity> getProjectsByMonth(int month) throws ADPException {
		return projectDAO.getProjectsByMonth(month);
	}

	public ProjectEntity addProject(ProjectEntity p) throws ADPException {
		return projectDAO.addProject(p);
	}

	public ProjectEntity getProject(Long idProject) throws ADPException {
		return projectDAO.getProject(idProject);
	}

	public void updateProject(ProjectEntity p) throws ADPException {
		projectDAO.updateProject(p);
	}

	public void deleteProject(Long idProject) throws ADPException {
		projectDAO.deleteProject(idProject);
	}

	public List<ProjectEntity> getAllProjects() throws ADPException {
		return projectDAO.getAllProjects();
	}

	public ProjectEntity getProjectByName(String name) throws ADPException {
		return projectDAO.getProjectByName(name);
	}

	
}
