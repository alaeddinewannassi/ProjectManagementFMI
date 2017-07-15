package com.adp.business.services;

import java.util.List;


import com.adp.entities.FunctionEntity;
import com.adp.exceptions.ADPException;



public interface FunctionService {

	public FunctionEntity addFunction(FunctionEntity p) throws ADPException ;
	public FunctionEntity getFunction(Long idFunction) throws ADPException ;
	public void updateFunction(FunctionEntity p) throws ADPException ;
	public void deleteFunction(Long idFunction) throws ADPException ;
	List<FunctionEntity> getAllFunctions()throws ADPException ;
	List<FunctionEntity> getFunctionsByMission(Long missionId) throws ADPException;
}
