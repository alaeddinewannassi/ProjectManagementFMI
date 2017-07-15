package com.adp.control.actions;




import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ProjectService;
import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.StringUtil;

public class ProjectUtilAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	@Autowired
	ProjectService projectService ;
	
	private String projectName ;
	
	private float budget ;
	
	private String client ;
	
	private int period ;
	
	private Long id ;
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	

	public ProjectUtilAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}
	
	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String saveProject() throws ADPException {
		
		try {
		if (!check()) {
			addActionError("verify project fields (*)!");
			return "addProject" ;
		}
		 
			ProjectEntity p = new ProjectEntity(projectName,period,budget,client);
			projectService.addProject(p);
			addActionMessage("the project "+projectName+" was added successefully ! ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return SUCCESS ;
	}
	
	public String updateProject() throws ADPException {
		
	
		ProjectEntity p = projectService.getProject(id);
		p.setBudget(budget);
		p.setClient(client);
		p.setPeriod(period);
		p.setProjectName(projectName);
		
		projectService.updateProject(p);
		
		addActionMessage("the project "+projectName+" was updated successefully ! ");
		
		return SUCCESS ;
	}
	


	
	private boolean check() {
		if(StringUtil.isEmpty(projectName) ||StringUtil.isEmpty(client) || budget==0 || period==0){
			return false;
		}
		
		return true;
	}
	
	
	
}
