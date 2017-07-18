package com.adp.business.dao;

import java.util.List;

import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;

public interface ThirdPartyDAO extends GenericDAO<ThirdPartyEntity>{
		
	public ThirdPartyEntity addThirdParty(ThirdPartyEntity p) throws ADPException ;
	public ThirdPartyEntity getThirdParty(Long idThirdParty) throws ADPException ;
	public void updateThirdParty(ThirdPartyEntity p) throws ADPException ;
	public void deleteThirdParty(Long idThirdParty) throws ADPException ;
	List<ThirdPartyEntity> getAllThirdPartys()throws ADPException ;
	public List<ThirdPartyEntity> getThirdPartysByTeam(Long teamId)throws ADPException ;
	public ThirdPartyEntity getThirdPartyByAdresse(String adresse) throws ADPException ;
	

}
