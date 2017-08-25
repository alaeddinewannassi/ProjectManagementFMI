package com.adp.business.dao.impl;

import java.util.Date;
import java.util.List;

import com.adp.business.dao.TimesheetInstanceDAO;
import com.adp.entities.TimesheetInputEntity;
import com.adp.entities.TimesheetInstanceEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

public class TimesheetInstanceDAOImpl extends GenericDAOImpl<TimesheetInstanceEntity> implements TimesheetInstanceDAO {

	@Override
	public TimesheetInstanceEntity addInstance(TimesheetInstanceEntity t) throws ADPException {
		return persist(t);
	}

	@Override
	public TimesheetInstanceEntity getInstance(Long id) throws ADPException {
		return load(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimesheetInstanceEntity> getLatestInstanceByInput(TimesheetInputEntity t) throws ADPException {

		String q = "from TimesheetInstanceEntity where importDate >= ALL ( from TimesheetInstanceEntity m where m.timesheet = ? )  ";
		return getHibernateTemplate().find(q, t);
	}

	@Override
	public void updateInstance(TimesheetInstanceEntity t) throws ADPException {
		merge(t);
	}

	@Override
	public void deleteInstance(Long id) throws ADPException {
		remove(id);
	}

	@Override
	public TimesheetInstanceEntity getLatestInstanceByMonth(int m) throws ADPException {

		String query = "from TimesheetInstanceEntity t where t.timesheet.month= :x and t.importDate= ( select max(k.importDate) from TimesheetInstanceEntity k )";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x", m);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (TimesheetInstanceEntity) result.get(0);
		} else
			return null;
	}

	@Override
	public List<TimesheetInstanceEntity> getAllInstances() throws ADPException {
		return findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimesheetInstanceEntity> getInstancesByMonth(int month) throws ADPException {
		String q = " from TimesheetInstanceEntity m where m.timesheet.month = ? ";
		return getHibernateTemplate().find(q, month);
	}

	@Override
	public TimesheetInstanceEntity getInstanceByImportDate(Date importDate) throws ADPException {
		String query = "from TimesheetInstanceEntity m where m.importDate = :x";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x", importDate);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (TimesheetInstanceEntity) result.get(0);
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimesheetInstanceEntity> getInstancesByProject(String projectName) throws ADPException {
		String q = " from TimesheetInstanceEntity m where m.timesheet.project.projectName = ? ";
		return getHibernateTemplate().find(q, projectName);
	}

	

}
