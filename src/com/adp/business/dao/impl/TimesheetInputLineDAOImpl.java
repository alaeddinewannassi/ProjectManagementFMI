package com.adp.business.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.adp.business.dao.TimesheetInputLineDAO;
import com.adp.entities.MissionEntity;
import com.adp.entities.TimesheetInputLineEntity;
import com.adp.entities.TimesheetInstanceEntity;
import com.adp.exceptions.ADPException;

public class TimesheetInputLineDAOImpl extends GenericDAOImpl<TimesheetInputLineEntity>
		implements TimesheetInputLineDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<MissionEntity> getMissionsByInstance(TimesheetInstanceEntity inst) throws ADPException {
		String q = " select DISTINCT e.mission from TimesheetInputLineEntity e where e.timesheetInstance = ? ";
		return getHibernateTemplate().find(q,inst);
	}

	@Override
	public TimesheetInputLineEntity addTimesheetInputLine(TimesheetInputLineEntity t) throws ADPException {
		return persist(t);
	}

	@Override
	public TimesheetInputLineEntity getTimesheetInputLine(Long id) throws ADPException {
		return load(id);
	}

	@Override
	public void updateTimesheetInputLine(TimesheetInputLineEntity t) throws ADPException {
		merge(t);
	}

	@Override
	public void deleteTimesheetInputLine(Long id) throws ADPException {
		remove(id);
	}

	@Override
	public List<TimesheetInputLineEntity> getAllTimesheetInputLines() throws ADPException {
		return findAll();
	}

	@Override
	public boolean ContributorExistsInTimeSheet(final String name) throws ADPException {

		Long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) {
				Query query = session
						.createQuery("select count(*) from TimesheetInputLineEntity t where t.contributorName= :x");
				query.setParameter("x", name);
				return (Long) query.uniqueResult();

			}
		});

		if (count > 0) {
			return true;
		}
		return false;

	}

	@Override
	public boolean ImportDateExistsInTimeSheet(final Date importDate) throws ADPException {

		Long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) {
				Query query = session.createQuery(
						"select count(*) from TimesheetInputLineEntity t where t.timesheetInstance.importDate= :x");
				query.setParameter("x", importDate);
				return (Long) query.uniqueResult();

			}
		});

		if (count > 0) {
			return true;
		}
		return false;

	}

}
