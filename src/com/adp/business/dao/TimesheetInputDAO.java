package com.adp.business.dao;

import java.util.List;

import com.adp.entities.TimesheetInputEntity;
import com.adp.exceptions.ADPException;

public interface TimesheetInputDAO extends GenericDAO<TimesheetInputEntity> {

	public TimesheetInputEntity addTimesheet(TimesheetInputEntity t) throws ADPException;

	public TimesheetInputEntity getTimesheet(Long id) throws ADPException;

	public void updateTimesheet(TimesheetInputEntity t) throws ADPException;

	public void deleteTimesheet(Long id) throws ADPException;

	public List<TimesheetInputEntity> getAllTimesheets() throws ADPException;
	
	public List<TimesheetInputEntity> getAllTimesheets(int month) throws ADPException;

	public List<String> getAllTimesheetsByDistinctMonth() throws ADPException;
}
