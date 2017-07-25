package com.adp.business.dao;

import com.adp.entities.TimesheetInputEntity;
import com.adp.exceptions.ADPException;

public interface TimesheetDAO extends GenericDAO<TimesheetInputEntity> {

	public TimesheetInputEntity addTimesheet(TimesheetInputEntity t) throws ADPException;
	public TimesheetInputEntity getTimesheet(Long id)throws ADPException ;
	public void updateTimesheet(TimesheetInputEntity t)throws ADPException  ;
	public void deleteTimesheet(Long id) throws ADPException;
}
