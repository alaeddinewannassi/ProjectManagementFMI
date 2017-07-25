package com.adp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FMI_TIMESHEET_INPUT")
public class TimesheetInputEntity extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	
	
	private int month ;
	private boolean completed ;
	
	@OneToMany(mappedBy="timesheet",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<TimesheetInputLineEntity> inputLines = new HashSet<TimesheetInputLineEntity>() ;
	
	@OneToMany(mappedBy="timesheet")
	private Set<TimesheetErrorEntity> errors = new HashSet<TimesheetErrorEntity>();
	
	
	public Set<TimesheetInputLineEntity> getInputLines() {
		return inputLines;
	}
	public void setInputLines(Set<TimesheetInputLineEntity> inputLines) {
		this.inputLines = inputLines;
	}

	
	public Set<TimesheetErrorEntity> getErrors() {
		return errors;
	}
	public void setErrors(Set<TimesheetErrorEntity> errors) {
		this.errors = errors;
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
