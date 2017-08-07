package com.adp.business.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.TimesheetInstanceDAO;
import com.adp.business.services.TimesheetInstanceService;
import com.adp.entities.TimesheetInstanceEntity;
import com.adp.exceptions.ADPException;

@Service("timesheetInstanceService")
public class TimesheetInstanceServiceImpl implements TimesheetInstanceService{

	@Autowired
	TimesheetInstanceDAO timesheetInstanceDAO;
	@Override
	public TimesheetInstanceEntity addInstance(TimesheetInstanceEntity t) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInstanceDAO.addInstance(t);
	}

	@Override
	public TimesheetInstanceEntity getInstance(Long id) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInstanceDAO.getInstance(id);
	}

	@Override
	public void updateInstance(TimesheetInstanceEntity t) throws ADPException {
		// TODO Auto-generated method stub
		timesheetInstanceDAO.updateInstance(t);
	}

	@Override
	public void deleteInstance(Long id) throws ADPException {
		// TODO Auto-generated method stub
		timesheetInstanceDAO.deleteInstance(id);
	}

	@Override
	public TimesheetInstanceEntity getLatestInstanceByMonth(int m) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInstanceDAO.getLatestInstanceByMonth(m);
	}

	@Override
	public List<TimesheetInstanceEntity> getAllInstances() throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInstanceDAO.getAllInstances();
	}

	@Override
	public List<TimesheetInstanceEntity> getInstancesByMonth(int month) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInstanceDAO.getInstancesByMonth(month);
	}

	@Override
	public TimesheetInstanceEntity getInstanceByImportDate(Date importDate) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInstanceDAO.getInstanceByImportDate(importDate);
	}

	@Override
	public List<TimesheetInstanceEntity> getInstancesByProject(String projectName) throws ADPException {
		// TODO Auto-generated method stub
		return timesheetInstanceDAO.getInstancesByProject(projectName);
	}

}
