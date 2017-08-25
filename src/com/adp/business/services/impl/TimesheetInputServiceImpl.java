package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.TimesheetInputDAO;
import com.adp.business.services.TimesheetInputService;
import com.adp.entities.TimesheetInputEntity;
import com.adp.exceptions.ADPException;


@Service("timesheetService")
public class TimesheetInputServiceImpl implements TimesheetInputService{

	@Autowired
	TimesheetInputDAO timesheetDAO ;
	
	
	@Override
	public List<TimesheetInputEntity> getAllTimesheets(int month) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetDAO.getAllTimesheets(month);
	}

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
	public List<TimesheetInputEntity> getAllTimesheets() throws ADPException {
		// TODO Auto-generated method stub
		return timesheetDAO.getAllTimesheets();
	}


	@Override
	public List<String> getAllTimesheetsByDistinctMonth() throws ADPException {
		// TODO Auto-generated method stub
		return timesheetDAO.getAllTimesheetsByDistinctMonth();
	}

	

	

}
