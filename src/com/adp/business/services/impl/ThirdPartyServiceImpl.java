package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adp.business.dao.ThirdPartyDAO;
import com.adp.business.services.ThirdPartyService;
import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;

@Service("ThirdPartyService")
public class ThirdPartyServiceImpl implements ThirdPartyService {

	@Autowired
	ThirdPartyDAO thirdPartyDAO ;
	
	public ThirdPartyEntity addThirdParty(ThirdPartyEntity p) throws ADPException {
		// TODO Auto-generated method stub
		return thirdPartyDAO.addThirdParty(p);
	}

	public ThirdPartyEntity getThirdParty(Long idThirdParty) throws ADPException {
		// TODO Auto-generated method stub
		return thirdPartyDAO.getThirdParty(idThirdParty);
	}

	public void updateThirdParty(ThirdPartyEntity p) throws ADPException {
		thirdPartyDAO.updateThirdParty(p);
		
	}

	public void deleteThirdParty(Long idThirdParty) throws ADPException {
		thirdPartyDAO.deleteThirdParty(idThirdParty);
	}

	public List<ThirdPartyEntity> getAllThirdParties() throws ADPException {
		return thirdPartyDAO.getAllThirdParties();
	}


	@Override
	public List<ThirdPartyEntity> getThirdPartiesByTeam(Long teamId) throws ADPException {
		// TODO Auto-generated method stub
		return thirdPartyDAO.getThirdPartiesByTeam(teamId);
	}

	@Override
	public ThirdPartyEntity getThirdPartyByAdresse(String adresse) throws ADPException {
		// TODO Auto-generated method stub
		return thirdPartyDAO.getThirdPartyByAdresse(adresse);
	}

	@Override
	public ThirdPartyEntity getThirdPartyByName(String name) throws ADPException {
		// TODO Auto-generated method stub
		return thirdPartyDAO.getThirdPartyByName(name);
	}

	@Override
	public boolean thirdPartyExistsinDB(String name) throws ADPException {
		// TODO Auto-generated method stub
		return thirdPartyDAO.thirdPartyExistsinDB(name);
	}

}
