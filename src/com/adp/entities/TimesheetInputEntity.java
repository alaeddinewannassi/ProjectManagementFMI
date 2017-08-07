package com.adp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="FMI_TIMESHEET_INPUT")
public class TimesheetInputEntity extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	
	private int month ;
	private boolean completed ;
	
	
	@OneToOne
	@JoinColumn(name="Project_ID")
	private ProjectEntity project ;
	
	@ManyToOne
	@JoinColumn(name="thirdParty_ID")
	private ThirdPartyEntity thirdParty ; 
	

	@OneToMany(mappedBy="timesheet",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<TimesheetInstanceEntity> timesheetInstances = new HashSet<TimesheetInstanceEntity>() ;
	
	
	public ProjectEntity getProject() {
		return project;
	}
	public void setProject(ProjectEntity project) {
		this.project = project;
	}
	
	public Set<TimesheetInstanceEntity> getTimesheetInstances() {
		return timesheetInstances;
	}
	public void setTimesheetInstances(Set<TimesheetInstanceEntity> timesheetInstances) {
		this.timesheetInstances = timesheetInstances;
	}
	
	
	public ThirdPartyEntity getThirdParty() {
		return thirdParty;
	}
	public void setThirdParty(ThirdPartyEntity thirdParty) {
		this.thirdParty = thirdParty;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public TimesheetInputEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TimesheetInputEntity(int month, boolean completed) {
		super();
		this.month = month;
		this.completed = completed;
	}
	
	
	
	
	
	
	
}
