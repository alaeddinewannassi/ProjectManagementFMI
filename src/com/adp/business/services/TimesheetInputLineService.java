package com.adp.business.services;

import java.util.Date;
import java.util.List;

import com.adp.entities.MissionEntity;
import com.adp.entities.TimesheetInputLineEntity;
import com.adp.entities.TimesheetInstanceEntity;
import com.adp.exceptions.ADPException;

public interface TimesheetInputLineService {

	public TimesheetInputLineEntity addTimesheetInputLine(TimesheetInputLineEntity t) throws ADPException;

	public TimesheetInputLineEntity getTimesheetInputLine(Long id) throws ADPException;

	public void updateTimesheetInputLine(TimesheetInputLineEntity t) throws ADPException;

	public void deleteTimesheetInputLine(Long id) throws ADPException;

	public List<TimesheetInputLineEntity> getAllTimesheetInputLines() throws ADPException;

	public boolean ContributorExistsInTimeSheet(final String name) throws ADPException;

	public boolean ImportDateExistsInTimeSheet(Date importDate) throws ADPException;

	public List<MissionEntity> getMissionsByInstance(TimesheetInstanceEntity inst) throws ADPException;
}
