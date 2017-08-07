package com.adp.business.dao.impl;

import java.util.List;

import com.adp.business.dao.TimesheetInputDAO;
import com.adp.entities.TimesheetInputEntity;
import com.adp.exceptions.ADPException;

public class TimesheetInputDAOImpl extends GenericDAOImpl<TimesheetInputEntity> implements TimesheetInputDAO{

	
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

	
	@Override
	public List<TimesheetInputEntity> getAllTimesheets() throws ADPException {

		
		return findAll();
	}

	

	

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllTimesheetsByDistinctMonth() throws ADPException {
		// TODO Auto-generated method stub
		String q =" select DISTINCT e.month from TimesheetInputEntity e " ;
		return getHibernateTemplate().find(q);
	}

	


	

	
	}


