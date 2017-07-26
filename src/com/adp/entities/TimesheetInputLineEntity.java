package com.adp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FMI_TIMESHEET_INPUT_LINE")
public class TimesheetInputLineEntity extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date ;
	private String comment ;
	private float hours ;
	
	@ManyToOne
	@JoinColumn(name="timesheet_ID")
	private TimesheetInputEntity timesheet;
	
	@ManyToOne
	@JoinColumn(name="ThirdParty_ID")
	private ThirdPartyEntity humanRessource ;
	
	@ManyToOne
	@JoinColumn(name="mission_ID")
	private MissionEntity mission ;
	
	@ManyToOne
	@JoinColumn(name="function_ID")
	private FunctionEntity function ;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public MissionEntity getMission() {
		return mission;
	}
	public void setMission(MissionEntity mission) {
		this.mission = mission;
	}
	public FunctionEntity getFunction() {
		return function;
	}
	public void setFunction(FunctionEntity function) {
		this.function = function;
	}
	
	public ThirdPartyEntity getHumanRessource() {
		return humanRessource;
	}
	public void setHumanRessource(ThirdPartyEntity humanRessource) {
		this.humanRessource = humanRessource;
	}
	
	public TimesheetInputEntity getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(TimesheetInputEntity timesheet) {
		this.timesheet = timesheet;
	}
	public TimesheetInputLineEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TimesheetInputLineEntity(Date date, String comment, float hours) {
		super();
		this.date = date;
		this.comment = comment;
		this.hours = hours;
	}
	
}
