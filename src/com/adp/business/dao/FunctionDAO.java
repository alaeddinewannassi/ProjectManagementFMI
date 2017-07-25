package com.adp.business.dao;

import java.util.List;

import com.adp.entities.FunctionEntity;
import com.adp.exceptions.ADPException;

public interface FunctionDAO extends GenericDAO<FunctionEntity> {

	public FunctionEntity addFunction(FunctionEntity p) throws ADPException ;
	public FunctionEntity getFunction(Long idFunction) throws ADPException ;
	public void updateFunction(FunctionEntity p) throws ADPException ;
	public void deleteFunction(Long idFunction) throws ADPException ;
	public List<FunctionEntity> getAllFunctions()throws ADPException ;
	public List<FunctionEntity> getFunctionsByMission(Long missionId) throws ADPException;
	public FunctionEntity getFunctionsByName(String functionName) throws ADPException;
}
