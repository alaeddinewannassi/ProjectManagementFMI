package com.adp.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FMI_TIMESHEET_ERROR")
public class TimesheetErrorEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String errorDescription;
	private String errorType;
	private String possibleSolution;

	@ManyToOne
	@JoinColumn(name = "instance_ID")
	TimesheetInstanceEntity timesheetInstance;

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getPossibleSolution() {
		return possibleSolution;
	}

	public void setPossibleSolution(String possibleSolution) {
		this.possibleSolution = possibleSolution;
	}

	public TimesheetInstanceEntity getTimesheetInstance() {
		return timesheetInstance;
	}

	public void setTimesheetInstance(TimesheetInstanceEntity timesheetInstance) {
		this.timesheetInstance = timesheetInstance;
	}

	public TimesheetErrorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TimesheetErrorEntity(String errorDescription, String errorType, String possibleSolution) {
		super();
		this.errorDescription = errorDescription;
		this.errorType = errorType;
		this.possibleSolution = possibleSolution;
	}

}
