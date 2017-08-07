package com.adp.business.dao.impl;

import java.util.List;

import com.adp.business.dao.AffectationDAO;
import com.adp.entities.AffectationEntity;
import com.adp.exceptions.ADPException;

public class AffectationDAOImpl extends GenericDAOImpl<AffectationEntity> implements AffectationDAO {

	@Override
	public AffectationEntity addAffectation(AffectationEntity p) throws ADPException {
		// TODO Auto-generated method stub
		return persist(p) ;
	}

	@Override
	public AffectationEntity getAffectation(Long idAffectation) throws ADPException {
		// TODO Auto-generated method stub
		return load(idAffectation);
	}

	@Override
	public void updateAffectation(AffectationEntity p) throws ADPException {
		// TODO Auto-generated method stub
		merge(p);
	}

	@Override
	public void deleteAffectation(Long idAffectation) throws ADPException {
		// TODO Auto-generated method stub
		remove(idAffectation);
	}

	@Override
	public List<AffectationEntity> getAllAffectations() throws ADPException {
		// TODO Auto-generated method stub
		return findAll();
	}

}
