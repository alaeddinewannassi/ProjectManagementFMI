package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.AffectationDAO;
import com.adp.business.services.AffectationService;
import com.adp.entities.AffectationEntity;
import com.adp.exceptions.ADPException;

@Service("affectationService")
public class AffectationServiceImpl implements AffectationService {

	@Autowired
	AffectationDAO affectationDAO ;
	
	@Override
	public AffectationEntity addAffectation(AffectationEntity p) throws ADPException {
		// TODO Auto-generated method stub
		return affectationDAO.addAffectation(p);
	}

	@Override
	public AffectationEntity getAffectation(Long idAffectation) throws ADPException {
		// TODO Auto-generated method stub
		return affectationDAO.getAffectation(idAffectation);
	}

	@Override
	public void updateAffectation(AffectationEntity p) throws ADPException {
		// TODO Auto-generated method stub
		affectationDAO.updateAffectation(p);
	}

	@Override
	public void deleteAffectation(Long idAffectation) throws ADPException {
		// TODO Auto-generated method stub
		affectationDAO.deleteAffectation(idAffectation);
	}

	@Override
	public List<AffectationEntity> getAllAffectations() throws ADPException {
		// TODO Auto-generated method stub
		return affectationDAO.getAllAffectations();
	}

	
}
