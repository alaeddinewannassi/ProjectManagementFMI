package com.adp.business.dao.impl;

import java.util.List;

import com.adp.business.dao.TimesheetDAO;
import com.adp.entities.TimesheetInputEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

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

	@Override
	public TimesheetInputEntity getTimesheetByMonth(int m) throws ADPException {

		String query = "from TimesheetInputEntity where month= :x";
		
		
        @SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x",m);

		if(CollectionsUtil.isNotEmpty(result)) {
			return (TimesheetInputEntity)result.get(0);
		}
		else return null;
	}

	@Override
	public List<TimesheetInputEntity> getAllTimesheets() throws ADPException {
		// TODO Auto-generated method stub
		return findAll();
	}
	
	}


