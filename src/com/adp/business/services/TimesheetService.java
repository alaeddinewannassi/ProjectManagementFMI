package com.adp.business.services;

import com.adp.entities.TimesheetInputEntity;
import com.adp.exceptions.ADPException;

public interface TimesheetService {
	public TimesheetInputEntity addTimesheet(TimesheetInputEntity t) throws ADPException;
	public TimesheetInputEntity getTimesheet(Long id)throws ADPException ;
	public void updateTimesheet(TimesheetInputEntity t)throws ADPException  ;
	public void deleteTimesheet(Long id) throws ADPException;
}
