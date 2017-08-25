package com.adp.business.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.adp.business.dao.TimesheetErrorDAO;
import com.adp.entities.TimesheetErrorEntity;
import com.adp.exceptions.ADPException;

public class TimesheetErrorDAOImpl extends GenericDAOImpl<TimesheetErrorEntity> implements TimesheetErrorDAO {

	@Override
	public TimesheetErrorEntity addTimesheetErrorLine(TimesheetErrorEntity t) throws ADPException {
		// TODO Auto-generated method stub
		return persist(t);
	}

	@Override
	public TimesheetErrorEntity getTimesheetErrorLine(Long id) throws ADPException {
		// TODO Auto-generated method stub
		return load(id);
	}

	@Override
	public void updateTimesheetErrorLine(TimesheetErrorEntity t) throws ADPException {
		// TODO Auto-generated method stub
		merge(t);
	}

	@Override
	public void deleteTimesheetErrorLine(Long id) throws ADPException {
		// TODO Auto-generated method stub
		remove(id);
	}

	@Override
	public List<TimesheetErrorEntity> getAllTimesheetErrorLines() throws ADPException {
		// TODO Auto-generated method stub
		return findAll();
	}

	@Override
	public boolean ContributorExistsInTimeSheet(final String name) throws ADPException {

		Long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) {
				Query query = session
						.createQuery("select count(*) from TimesheetErrorEntity t where t.contributorName= :x");
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
						"select count(*) from TimesheetErrorEntity t where t.timesheetInstance.importDate= :x");
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
