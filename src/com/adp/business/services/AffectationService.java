package com.adp.business.services;

import java.util.List;

import com.adp.entities.AffectationEntity;
import com.adp.exceptions.ADPException;

public interface AffectationService {

	public AffectationEntity addAffectation(AffectationEntity p) throws ADPException ;
	public AffectationEntity getAffectation(Long idAffectation) throws ADPException ;
	public void updateAffectation(AffectationEntity p) throws ADPException ;
	public void deleteAffectation(Long idAffectation) throws ADPException ;
	public List<AffectationEntity> getAllAffectations()throws ADPException ;
}
