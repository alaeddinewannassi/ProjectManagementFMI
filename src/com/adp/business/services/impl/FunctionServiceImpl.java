package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.FunctionDAO;
import com.adp.business.services.FunctionService;
import com.adp.entities.FunctionEntity;
import com.adp.exceptions.ADPException;




@Service("FunctionService")
public class FunctionServiceImpl implements FunctionService{

	@Autowired
	FunctionDAO FunctionDAO ;
	
	
	public FunctionEntity addFunction(FunctionEntity p) throws ADPException {
		return FunctionDAO.addFunction(p);
	}

	public FunctionEntity getFunction(Long idFunction) throws ADPException {
		return FunctionDAO.getFunction(idFunction);
	}

	public void updateFunction(FunctionEntity p) throws ADPException {
		FunctionDAO.updateFunction(p);
	}

	public void deleteFunction(Long idFunction) throws ADPException {
		FunctionDAO.deleteFunction(idFunction);
	}

	public List<FunctionEntity> getAllFunctions() throws ADPException {
		return FunctionDAO.getAllFunctions();
	}

	public List<FunctionEntity> getFunctionsByMission(Long missionId) throws ADPException {
		// TODO Auto-generated method stub
		return FunctionDAO.getFunctionsByMission(missionId);
	}

}
