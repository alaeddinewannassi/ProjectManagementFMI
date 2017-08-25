package com.adp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "FMI_TURNOVER")
public class TurnoverEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private float revisedWorkload;
	private float revisedBudgetAmount;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "turnover", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<MonthlyTurnoverEntity> monthlyTurnovers = new HashSet<MonthlyTurnoverEntity>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mission_ID")
	private MissionEntity mission;

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
		float res = 0;
		for (MonthlyTurnoverEntity m : monthlyTurnovers) {
			res = res + m.getTurnoverAmount();
		}

		return res;
	}

	public MissionEntity getMission() {
		return mission;
	}

	public void setMission(MissionEntity mission) {
		this.mission = mission;
	}

	public Set<MonthlyTurnoverEntity> getMonthlyTurnovers() {
		return monthlyTurnovers;
	}

	public void setMonthlyTurnovers(Set<MonthlyTurnoverEntity> monthlyTurnovers) {
		this.monthlyTurnovers = monthlyTurnovers;
	}
	public float getCumulatedActuals(){
		
		float res = 0;
		for(MonthlyTurnoverEntity m : monthlyTurnovers){
			res = res + m.getActual();  
		}
		return res ;
	}
	
	
	public TurnoverEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TurnoverEntity(float revisedWorkload, float revisedBudgetAmount) {
		super();
		this.revisedWorkload = revisedWorkload;
		this.revisedBudgetAmount = revisedBudgetAmount;
	}

}
