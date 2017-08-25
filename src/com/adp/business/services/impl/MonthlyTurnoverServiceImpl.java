package com.adp.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.MonthlyTurnoverDAO;
import com.adp.business.services.MonthlyTurnoverService;
import com.adp.entities.MonthlyTurnoverEntity;
import com.adp.exceptions.ADPException;

@Service("monthlyTurnoverService")
public class MonthlyTurnoverServiceImpl implements MonthlyTurnoverService {

	@Autowired
	MonthlyTurnoverDAO monthlyTurnoverDAO;

	@Override
	public void updateMonthlyTurnover(MonthlyTurnoverEntity m) throws ADPException {
		monthlyTurnoverDAO.updateMonthlyTurnover(m);
	}

	@Override
	public MonthlyTurnoverEntity getMonthlyTurnover(Long id) throws ADPException {
		return monthlyTurnoverDAO.getMonthlyTurnover(id);
	}

	@Override
	public MonthlyTurnoverEntity getLatestMonthlyTurnover(int month, Long id) throws ADPException {
		return monthlyTurnoverDAO.getLatestMonthlyTurnover(month, id);
	}

	@Override
	public List<MonthlyTurnoverEntity> getAllMonthlyTurnovers() throws ADPException {
		return monthlyTurnoverDAO.getAllMonthlyTurnovers();
	}

	@Override
	public boolean existMonthlyTurnover(int month) throws ADPException {
		// TODO Auto-generated method stub
		return monthlyTurnoverDAO.existMonthlyTurnover(month);
	}

}
