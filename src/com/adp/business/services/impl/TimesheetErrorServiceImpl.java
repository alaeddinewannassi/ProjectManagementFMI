package com.adp.business.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.TimesheetErrorDAO;
import com.adp.business.services.TimesheetErrorService;
import com.adp.entities.TimesheetErrorEntity;
import com.adp.exceptions.ADPException;

@Service("timesheetErrorService")
public class TimesheetErrorServiceImpl implements TimesheetErrorService{

	@Autowired
	TimesheetErrorDAO timesheetErrorDAO ;
	@Override
	public TimesheetErrorEntity addTimesheetErrorLine(TimesheetErrorEntity t) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetErrorDAO.addTimesheetErrorLine(t);
	}

	@Override
	public TimesheetErrorEntity getTimesheetErrorLine(Long id) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetErrorDAO.getTimesheetErrorLine(id);
	}

	@Override
	public void updateTimesheetErrorLine(TimesheetErrorEntity t) throws ADPException {
		// TODO Auto-generated method stub
		timesheetErrorDAO.updateTimesheetErrorLine(t);
	}

	@Override
	public void deleteTimesheetErrorLine(Long id) throws ADPException {
		// TODO Auto-generated method stub
		timesheetErrorDAO.deleteTimesheetErrorLine(id);
	}

	@Override
	public List<TimesheetErrorEntity> getAllTimesheetErrorLines() throws ADPException {
		// TODO Auto-generated method stub
		return timesheetErrorDAO.getAllTimesheetErrorLines();
	}

	@Override
	public boolean ContributorExistsInTimeSheet(String name) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetErrorDAO.ContributorExistsInTimeSheet(name);
	}

	@Override
	public boolean ImportDateExistsInTimeSheet(Date importDate) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetErrorDAO.ImportDateExistsInTimeSheet(importDate);
	}

}
