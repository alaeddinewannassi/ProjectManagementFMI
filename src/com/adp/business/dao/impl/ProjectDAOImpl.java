package com.adp.business.dao.impl;

import java.util.List;

import com.adp.business.dao.ProjectDAO;
import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

public class ProjectDAOImpl extends GenericDAOImpl<ProjectEntity> implements ProjectDAO {

	public ProjectEntity addProject(ProjectEntity p) throws ADPException {
		
		return persist(p);
	}

	public ProjectEntity getProject(Long idProject) throws ADPException {
		
		return load(idProject);
	}

	public void updateProject(ProjectEntity p) throws ADPException {
		
		merge(p);
		
	}

	public void deleteProject(Long idProject) throws ADPException {
		remove(idProject);
	}

	public List<ProjectEntity> getAllProjects() throws ADPException {
		return findAll();
	}

	public ProjectEntity getProjectByName(String name) throws ADPException {
String query = "from ProjectEntity where projectName= :x";
		
		
        @SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x",name);

		if(CollectionsUtil.isNotEmpty(result)) {
			return (ProjectEntity)result.get(0);
		}
		else return null;
	}


	
	
	
}
