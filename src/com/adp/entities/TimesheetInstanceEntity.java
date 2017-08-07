package com.adp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FMI_TIMESHEET_INSTANCE")
public class TimesheetInstanceEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date importDate ;
	
	@ManyToOne
	@JoinColumn(name="timesheet_ID")
	private TimesheetInputEntity timesheet ;
	
	@OneToMany(mappedBy="timesheetInstance",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<TimesheetInputLineEntity> inputLines = new HashSet<TimesheetInputLineEntity>() ;
	
	@OneToMany(mappedBy="timesheetInstance",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<TimesheetErrorEntity> inputErrors = new HashSet<TimesheetErrorEntity>();
	
	

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public Set<TimesheetInputLineEntity> getInputLines() {
		return inputLines;
	}

	public void setInputLines(Set<TimesheetInputLineEntity> inputLines) {
		this.inputLines = inputLines;
	}

	public TimesheetInputEntity getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(TimesheetInputEntity timesheet) {
		this.timesheet = timesheet;
	}

	public Set<TimesheetErrorEntity> getInputErrors() {
		return inputErrors;
	}

	public void setInputErrors(Set<TimesheetErrorEntity> inputErrors) {
		this.inputErrors = inputErrors;
	}

	public TimesheetInstanceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TimesheetInstanceEntity(Date importDate) {
		super();
		this.importDate = importDate;
	}

	
	
	
	

}
