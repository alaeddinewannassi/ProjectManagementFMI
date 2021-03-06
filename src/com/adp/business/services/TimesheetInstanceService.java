package com.adp.business.services;

import java.util.Date;
import java.util.List;

import com.adp.entities.TimesheetInputEntity;
import com.adp.entities.TimesheetInstanceEntity;
import com.adp.exceptions.ADPException;

public interface TimesheetInstanceService {

	public TimesheetInstanceEntity addInstance(TimesheetInstanceEntity t) throws ADPException;

	public TimesheetInstanceEntity getInstance(Long id) throws ADPException;

	public void updateInstance(TimesheetInstanceEntity t) throws ADPException;

	public void deleteInstance(Long id) throws ADPException;

	public TimesheetInstanceEntity getLatestInstanceByMonth(int m) throws ADPException;

	public List<TimesheetInstanceEntity> getAllInstances() throws ADPException;

	public List<TimesheetInstanceEntity> getInstancesByMonth(int month) throws ADPException;

	public TimesheetInstanceEntity getInstanceByImportDate(Date importDate) throws ADPException;

	public List<TimesheetInstanceEntity> getInstancesByProject(String projectName) throws ADPException;
	
	public List<TimesheetInstanceEntity> getLatestInstanceByInput(TimesheetInputEntity t) throws ADPException;
}
