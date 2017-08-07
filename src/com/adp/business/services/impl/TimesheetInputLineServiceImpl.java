package com.adp.business.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.TimesheetInputLineDAO;
import com.adp.business.services.TimesheetInputLineService;
import com.adp.entities.TimesheetInputLineEntity;
import com.adp.exceptions.ADPException;

@Service("timesheetInputLineService")
public class TimesheetInputLineServiceImpl implements TimesheetInputLineService{
	
	@Autowired
	TimesheetInputLineDAO timesheetInputLineDAO; 
	
	@Override
	public TimesheetInputLineEntity addTimesheetInputLine(TimesheetInputLineEntity t) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInputLineDAO.addTimesheetInputLine(t);
	}

	@Override
	public TimesheetInputLineEntity getTimesheetInputLine(Long id) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInputLineDAO.getTimesheetInputLine(id);
	}

	@Override
	public void updateTimesheetInputLine(TimesheetInputLineEntity t) throws ADPException {
		// TODO Auto-generated method stub
		timesheetInputLineDAO.updateTimesheetInputLine(t);
	}

	@Override
	public void deleteTimesheetInputLine(Long id) throws ADPException {
		// TODO Auto-generated method stub
		timesheetInputLineDAO.deleteTimesheetInputLine(id);
	}

	@Override
	public List<TimesheetInputLineEntity> getAllTimesheetInputLines() throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInputLineDAO.getAllTimesheetInputLines();
	}

	@Override
	public boolean ContributorExistsInTimeSheet(String name) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInputLineDAO.ContributorExistsInTimeSheet(name) ;
	}

	@Override
	public boolean ImportDateExistsInTimeSheet(Date importDate) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInputLineDAO.ImportDateExistsInTimeSheet(importDate);
	}
	
}
