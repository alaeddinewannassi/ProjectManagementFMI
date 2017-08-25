package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.TurnoverDAO;
import com.adp.business.services.TurnoverService;
import com.adp.entities.MissionEntity;
import com.adp.entities.TurnoverEntity;
import com.adp.exceptions.ADPException;

@Service("turnoverService")
public class TurnoverServiceImpl implements TurnoverService {

	@Autowired
	TurnoverDAO turnoverDAO;

	@Override
	public TurnoverEntity getTurnover(MissionEntity m) throws ADPException {
		return turnoverDAO.getTurnover(m);
	}

	@Override
	public TurnoverEntity addTurnover(TurnoverEntity p) throws ADPException {
		return turnoverDAO.addTurnover(p);
	}

	@Override
	public TurnoverEntity getTurnover(Long id) throws ADPException {
		return turnoverDAO.getTurnover(id);
	}

	@Override
	public void updateTurnover(TurnoverEntity p) throws ADPException {
		turnoverDAO.updateTurnover(p);
	}

	@Override
	public void deleteTurnover(Long id) throws ADPException {
		turnoverDAO.deleteTurnover(id);
	}

	@Override
	public List<TurnoverEntity> getAllTurnovers() throws ADPException {
		return turnoverDAO.getAllTurnovers();
	}

}
