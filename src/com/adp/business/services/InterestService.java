package com.adp.business.services;

import java.util.List;

import com.adp.entities.InterestEntity;
import com.adp.exceptions.ADPException;

public interface InterestService {
	Long addInterest(InterestEntity i) throws ADPException;
	public InterestEntity getInterest(Long id)throws ADPException ;
	public List<InterestEntity> getAllInterests()throws ADPException ;	
	public InterestEntity getInterestByName(String name)throws ADPException ;
}
