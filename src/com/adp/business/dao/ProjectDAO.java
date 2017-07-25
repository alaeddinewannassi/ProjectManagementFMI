package com.adp.business.dao;

import java.util.List;

import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;

public interface ProjectDAO extends GenericDAO<ProjectEntity>{
		
	public ProjectEntity addProject(ProjectEntity p) throws ADPException ;
	public ProjectEntity getProject(Long idProject) throws ADPException ;
	public void updateProject(ProjectEntity p) throws ADPException ;
	public void deleteProject(Long idProject) throws ADPException ;
	public List<ProjectEntity> getAllProjects()throws ADPException ;
	public ProjectEntity getProjectByName(String name)throws ADPException ;
	
}
