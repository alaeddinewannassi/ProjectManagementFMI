package com.adp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FMI_TURNOVER")
public class TurnoverEntity extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float revisedWorkload ;
	private float revisedBudgetAmount ;
	private float turnoverAmount ;
	
	@OneToMany
	private List<MonthlyTurnoverEntity> monthlyTurnovers ;
	
	@OneToOne(mappedBy="mission_ID")
	private MissionEntity mission ;

	public float getRevisedWorkload() {
		return revisedWorkload;
	}

	public void setRevisedWorkload(float revisedWorkload) {
		this.revisedWorkload = revisedWorkload;
	}

	public float getRevisedBudgetAmount() {
		return revisedBudgetAmount;
	}

	public void setRevisedBudgetAmount(float revisedBudgetAmount) {
		this.revisedBudgetAmount = revisedBudgetAmount;
	}

	public float getTurnoverAmount() {
		return turnoverAmount;
	}

	public void setTurnoverAmount(float turnoverAmount) {
		this.turnoverAmount = turnoverAmount;
	}

	public MissionEntity getMission() {
		return mission;
	}

	public void setMission(MissionEntity mission) {
		this.mission = mission;
	}
	
	public List<MonthlyTurnoverEntity> getMonthlyTurnovers() {
		return monthlyTurnovers;
	}

	public void setMonthlyTurnovers(List<MonthlyTurnoverEntity> monthlyTurnovers) {
		this.monthlyTurnovers = monthlyTurnovers;
	}

	public TurnoverEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TurnoverEntity(float revisedWorkload, float revisedBudgetAmount, float turnoverAmount) {
		super();
		this.revisedWorkload = revisedWorkload;
		this.revisedBudgetAmount = revisedBudgetAmount;
		this.turnoverAmount = turnoverAmount;
	}
	
	
	
	
	
	
	
	

}
