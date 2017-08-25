package com.adp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FMI_FUNCTION")
public class FunctionEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String functionName;
	private String description;

	@OneToMany(mappedBy = "function", cascade = CascadeType.ALL)
	private Set<TimesheetInputLineEntity> timesheetLines = new HashSet<TimesheetInputLineEntity>();

	@ManyToOne
	@JoinColumn(name = "missionId")
	private MissionEntity mission;

	private String status;

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public MissionEntity getMission() {
		return mission;
	}

	public void setMission(MissionEntity mission) {
		this.mission = mission;
	}

	public FunctionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FunctionEntity(String functionName, String description) {
		super();
		this.functionName = functionName;
		this.description = description;
		this.status = "0%";
	}

}
