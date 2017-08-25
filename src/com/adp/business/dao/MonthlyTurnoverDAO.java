package com.adp.business.dao;

import java.util.List;

import com.adp.entities.MonthlyTurnoverEntity;
import com.adp.exceptions.ADPException;

public interface MonthlyTurnoverDAO extends GenericDAO<MonthlyTurnoverEntity> {

	public MonthlyTurnoverEntity getMonthlyTurnover(Long id) throws ADPException;

	public MonthlyTurnoverEntity getLatestMonthlyTurnover(int month,Long id) throws ADPException;
	
	public List<MonthlyTurnoverEntity> getAllMonthlyTurnovers() throws ADPException; 
	
	public void updateMonthlyTurnover(MonthlyTurnoverEntity m) throws ADPException;
	
	public boolean existMonthlyTurnover(int month) throws ADPException;
	

}
