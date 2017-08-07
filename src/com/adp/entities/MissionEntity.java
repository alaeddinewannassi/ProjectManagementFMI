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
@Table(name = "FMI_MISSION")
public class MissionEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String missionName ;
	private String description ;
	private float budget ;
	private String status ;
	
	@OneToMany(mappedBy="mission",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<TimesheetInputLineEntity> timesheetLines = new HashSet<TimesheetInputLineEntity>(); 
	
	@ManyToOne
	@JoinColumn(name="projectId")
	private ProjectEntity project ;
	
	@OneToMany(mappedBy="mission",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<FunctionEntity> functions = new HashSet<FunctionEntity>() ;
	
	
	@OneToMany(mappedBy="thirdParty",cascade=CascadeType.ALL,fetch=FetchType.EAGER)

	private Set<AffectationEntity> affectation = new HashSet<AffectationEntity>();

	@OneToOne 
	private TurnoverEntity turnover ;

	
	public Set<TimesheetInputLineEntity> getTimesheetLines() {
		return timesheetLines;
	}
	public void setTimesheetLines(Set<TimesheetInputLineEntity> timesheetLines) {
		this.timesheetLines = timesheetLines;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Set<FunctionEntity> getFunctions() {
		return functions;
	}
	public void setFunctions(Set<FunctionEntity> functions) {
		this.functions = functions;
	}
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ProjectEntity getProject() {
		return project;
	}
	public void setProject(ProjectEntity project) {
		this.project = project;
	}
	public float getBudget() {
		return budget;
	}
	
	

	public Set<AffectationEntity> getAffectation() {
		return affectation;
	}
	public void setAffectation(Set<AffectationEntity> affectation) {
		this.affectation = affectation;
	}
	
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public MissionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionEntity(String missionName, float budget, String description) {
		super();
		this.missionName = missionName;
		this.budget = budget;
		this.description = description ; 
		
	}
	
	
	
	
	
}
