package com.adp.business.services;

import java.util.List;

import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;

public interface ThirdPartyService {
	public ThirdPartyEntity addThirdParty(ThirdPartyEntity p) throws ADPException ;
	public ThirdPartyEntity getThirdParty(Long idThirdParty) throws ADPException ;
	public void updateThirdParty(ThirdPartyEntity p) throws ADPException ;
	public void deleteThirdParty(Long idThirdParty) throws ADPException ;
	public List<ThirdPartyEntity> getAllThirdPartys()throws ADPException ;
	public List<ThirdPartyEntity> getThirdPartysByTeam(Long teamId)throws ADPException ;
	public ThirdPartyEntity getThirdPartyByAdresse(String adresse) throws ADPException ;
}
