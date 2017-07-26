package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.TimesheetDAO;
import com.adp.business.services.TimesheetService;
import com.adp.entities.TimesheetInputEntity;
import com.adp.exceptions.ADPException;


@Service("timesheetService")
public class TimesheetInputServiceImpl implements TimesheetService{

	@Autowired
	TimesheetDAO timesheetDAO ;
	
	@Override
	public TimesheetInputEntity addTimesheet(TimesheetInputEntity t) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetDAO.addTimesheet(t);
	}

	@Override
	public TimesheetInputEntity getTimesheet(Long id) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetDAO.getTimesheet(id);
	}

	@Override
	public void updateTimesheet(TimesheetInputEntity t) throws ADPException {
		// TODO Auto-generated method stub
		timesheetDAO.updateTimesheet(t);
	}

	@Override
	public void deleteTimesheet(Long id) throws ADPException {
		// TODO Auto-generated method stub
		timesheetDAO.deleteTimesheet(id);
	}

	@Override
	public TimesheetInputEntity getTimesheetByMonth(int m) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetDAO.getTimesheetByMonth(m);
	}

	@Override
	public List<TimesheetInputEntity> getAllTimesheets() throws ADPException {
		// TODO Auto-generated method stub
		return timesheetDAO.getAllTimesheets();
	}

}
