package com.adp.business.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.TimesheetInstanceDAO;
import com.adp.business.services.TimesheetInstanceService;
import com.adp.entities.TimesheetInputEntity;
import com.adp.entities.TimesheetInstanceEntity;
import com.adp.exceptions.ADPException;

@Service("timesheetInstanceService")
public class TimesheetInstanceServiceImpl implements TimesheetInstanceService{

	@Autowired
	TimesheetInstanceDAO timesheetInstanceDAO;

	@Override
	public List<TimesheetInstanceEntity> getLatestInstanceByInput(TimesheetInputEntity t) throws ADPException {
		return timesheetInstanceDAO.getLatestInstanceByInput(t);
	}

	@Override
	public TimesheetInstanceEntity addInstance(TimesheetInstanceEntity t) throws ADPException {
		return timesheetInstanceDAO.addInstance(t);
	}

	@Override
	public TimesheetInstanceEntity getInstance(Long id) throws ADPException {
		return timesheetInstanceDAO.getInstance(id);
	}

	@Override
	public void updateInstance(TimesheetInstanceEntity t) throws ADPException {
		timesheetInstanceDAO.updateInstance(t);
	}

	@Override
	public void deleteInstance(Long id) throws ADPException {
		timesheetInstanceDAO.deleteInstance(id);
	}

	@Override
	public TimesheetInstanceEntity getLatestInstanceByMonth(int m) throws ADPException {
		return timesheetInstanceDAO.getLatestInstanceByMonth(m);
	}

	@Override
	public List<TimesheetInstanceEntity> getAllInstances() throws ADPException {
		return timesheetInstanceDAO.getAllInstances();
	}

	@Override
	public List<TimesheetInstanceEntity> getInstancesByMonth(int month) throws ADPException {
		return timesheetInstanceDAO.getInstancesByMonth(month);
	}

	@Override
	public TimesheetInstanceEntity getInstanceByImportDate(Date importDate) throws ADPException {
		return timesheetInstanceDAO.getInstanceByImportDate(importDate);
	}

	@Override
	public List<TimesheetInstanceEntity> getInstancesByProject(String projectName) throws ADPException {
		return timesheetInstanceDAO.getInstancesByProject(projectName);
	}

}
