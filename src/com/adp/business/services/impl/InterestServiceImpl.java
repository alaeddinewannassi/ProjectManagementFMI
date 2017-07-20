package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.InterestDAO;
import com.adp.business.services.InterestService;
import com.adp.entities.InterestEntity;
import com.adp.exceptions.ADPException;


@Service("interestService")
public class InterestServiceImpl implements InterestService{
	
	@Autowired
	InterestDAO interestDAO ;
	
	@Override
	public Long addInterest(InterestEntity i) throws ADPException {
		// TODO Auto-generated method stub
		return interestDAO.addInterest(i);
	}

	@Override
	public InterestEntity getInterest(Long id) throws ADPException {
		// TODO Auto-generated method stub
		return interestDAO.getInterest(id);
	}

	@Override
	public List<InterestEntity> getAllInterests() throws ADPException {
		// TODO Auto-generated method stub
		return interestDAO.getAllInterests();
	}

	@Override
	public InterestEntity getInterestByName(String name) throws ADPException {
		// TODO Auto-generated method stub
		return interestDAO.getInterestByName(name);
	}

}
