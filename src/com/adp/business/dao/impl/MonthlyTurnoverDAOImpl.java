package com.adp.business.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.adp.business.dao.MonthlyTurnoverDAO;
import com.adp.entities.MonthlyTurnoverEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

public class MonthlyTurnoverDAOImpl extends GenericDAOImpl<MonthlyTurnoverEntity> implements MonthlyTurnoverDAO  {

	
	@Override
	public void updateMonthlyTurnover(MonthlyTurnoverEntity m) throws ADPException {
		merge(m);
	}

	@Override
	public MonthlyTurnoverEntity getMonthlyTurnover(Long id) throws ADPException {
		return load(id);
	}

	@Override
	public MonthlyTurnoverEntity getLatestMonthlyTurnover(int month ,Long id) throws ADPException {
			
		String query = "from MonthlyTurnoverEntity where month = :x and turnover.mission.id= :y ";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query,new String[]{"x","y"}, new Object[]{month,id});

		if (CollectionsUtil.isNotEmpty(result)) {
			return (MonthlyTurnoverEntity)result.get(0);
		} else
			return null;
		
	}

	@Override
	public List<MonthlyTurnoverEntity> getAllMonthlyTurnovers() throws ADPException {
		return findAll();
	}

	@Override
	public boolean existMonthlyTurnover(final int month) throws ADPException {

		Long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) {
				Query query = session.createQuery("select count(*) from MonthlyTurnoverEntity u where u.month= :x");
				query.setParameter("x", month);
				return (Long) query.uniqueResult();

			}
		});

		if (count > 0) {
			return true;
		}
		return false;
	}

	
	
}
