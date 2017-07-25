package com.adp.business.dao.impl;

import com.adp.business.dao.TimesheetDAO;
import com.adp.entities.TimesheetInputEntity;
import com.adp.exceptions.ADPException;

public class TimesheetDAOImpl extends GenericDAOImpl<TimesheetInputEntity> implements TimesheetDAO{

	
	@Override
	public TimesheetInputEntity addTimesheet(TimesheetInputEntity t) throws ADPException {
		// TODO Auto-generated method stub
		return persist(t);
	}

	@Override
	public TimesheetInputEntity getTimesheet(Long id) throws ADPException {
		// TODO Auto-generated method stub
		return load(id);
	}

	@Override
	public void updateTimesheet(TimesheetInputEntity t) throws ADPException {
		// TODO Auto-generated method stub
		merge(t);
	}

	@Override
	public void deleteTimesheet(Long id) throws ADPException {
		// TODO Auto-generated method stub
		remove(id);
	}

}
