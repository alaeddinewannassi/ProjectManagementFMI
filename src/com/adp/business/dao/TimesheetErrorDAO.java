package com.adp.business.dao;

import java.util.Date;
import java.util.List;

import com.adp.entities.TimesheetErrorEntity;
import com.adp.exceptions.ADPException;

public interface TimesheetErrorDAO extends GenericDAO<TimesheetErrorEntity> {

	public TimesheetErrorEntity addTimesheetErrorLine(TimesheetErrorEntity t) throws ADPException;

	public TimesheetErrorEntity getTimesheetErrorLine(Long id) throws ADPException;

	public void updateTimesheetErrorLine(TimesheetErrorEntity t) throws ADPException;

	public void deleteTimesheetErrorLine(Long id) throws ADPException;

	public List<TimesheetErrorEntity> getAllTimesheetErrorLines() throws ADPException;

	public boolean ContributorExistsInTimeSheet(String name) throws ADPException;

	public boolean ImportDateExistsInTimeSheet(Date importDate) throws ADPException;
}
