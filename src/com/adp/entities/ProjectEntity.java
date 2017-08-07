package com.adp.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "FMI_PROJECT")
public class ProjectEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	
	private String projectName ;
	
	private Date creationDate ;
	
	private int period ;
	
	
	@OneToOne(mappedBy="project",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private TimesheetInputEntity timesheet ;
	
	@OneToMany(mappedBy="project",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	
	private List<TeamEntity> teams ;
	
	private float budget ;
	
	private String status ;
	
	private String client ;
	
//	@ManyToOne
	//@JoinColumn(name="projectId")
	//private ManagerEntity projectManager ;

	
	@OneToMany(mappedBy="project",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<MissionEntity> missions = new HashSet<MissionEntity>() ;
	
	
	public TimesheetInputEntity getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(TimesheetInputEntity timesheet) {
		this.timesheet = timesheet;
	}
	
	/*public ManagerEntity getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(ManagerEntity projectManager) {
		this.projectManager = projectManager;
	}*/
	
	
	public String getProjectName() {
		return projectName;
	}
	public List<TeamEntity> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamEntity> teams) {
		this.teams = teams;
	}
	public Set<MissionEntity> getMissions() {
		return missions;
	}
	public void setMissions(Set<MissionEntity> missions) {
		this.missions = missions;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public ProjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public ProjectEntity(String projectName, int period, float budget, String client) {
		super();
		this.projectName = projectName;
		this.period = period;
		this.budget = budget;
		this.client = client;
		this.creationDate=new Date();
		this.status="0%";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}