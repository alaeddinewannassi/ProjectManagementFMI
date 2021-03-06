package com.adp.business.dao;

import java.util.List;

import com.adp.entities.MissionEntity;
import com.adp.entities.TurnoverEntity;
import com.adp.exceptions.ADPException;

public interface TurnoverDAO extends GenericDAO<TurnoverEntity> {

	public TurnoverEntity addTurnover(TurnoverEntity p) throws ADPException;

	public TurnoverEntity getTurnover(Long id) throws ADPException;
	
	public TurnoverEntity getTurnover(MissionEntity m) throws ADPException;

	public void updateTurnover(TurnoverEntity p) throws ADPException;

	public void deleteTurnover(Long id) throws ADPException;

	public List<TurnoverEntity> getAllTurnovers() throws ADPException;

}
