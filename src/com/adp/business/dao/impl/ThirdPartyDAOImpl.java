package com.adp.business.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.adp.business.dao.ThirdPartyDAO;
import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.CollectionsUtil;

public class ThirdPartyDAOImpl extends GenericDAOImpl<ThirdPartyEntity> implements ThirdPartyDAO {

	public ThirdPartyEntity addThirdParty(ThirdPartyEntity p) throws ADPException {

		return persist(p);
	}

	public ThirdPartyEntity getThirdParty(Long idThirdParty) throws ADPException {

		return load(idThirdParty);
	}

	public void updateThirdParty(ThirdPartyEntity p) throws ADPException {

		merge(p);

	}

	public void deleteThirdParty(Long idThirdParty) throws ADPException {
		remove(idThirdParty);
	}

	public List<ThirdPartyEntity> getAllThirdParties() throws ADPException {
		return findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThirdPartyEntity> getThirdPartiesByTeam(Long teamId) throws ADPException {
		String q = " from ThirdPartyEntity where team.id = ? ";
		return getHibernateTemplate().find(q, teamId);
	}

	@Override
	public ThirdPartyEntity getThirdPartyByAdresse(String adresse) throws ADPException {

		String query = "from ThirdPartyEntity where adresse= :x";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x", adresse);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (ThirdPartyEntity) result.get(0);
		} else
			return null;
	}

	@Override
	public ThirdPartyEntity getThirdPartyByName(String name) throws ADPException {

		String query = "from ThirdPartyEntity t where CONCAT(t.firstName,' ', t.lastName) = :x";

		@SuppressWarnings("rawtypes")
		List result = getHibernateTemplate().findByNamedParam(query, "x", name);

		if (CollectionsUtil.isNotEmpty(result)) {
			return (ThirdPartyEntity) result.get(0);
		} else
			return null;
	}

	@Override
	public boolean thirdPartyExistsinDB(final String name) throws ADPException {

		Long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) {
				Query query = session.createQuery(
						"select count(*) from thirdPartyEntity u where CONCAT(t.firstName,' ', t.lastName) = :x");
				query.setParameter("x", name);
				return (Long) query.uniqueResult();

			}
		});

		if (count > 0) {
			return true;
		}
		return false;

	}

}
