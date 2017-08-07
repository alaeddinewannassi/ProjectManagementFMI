package com.adp.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FMI_MONTHLY_TURNOVER")
public class MonthlyTurnoverEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int month  ;
	private float progress ;
	private float turnoverAmount ;
	private float RTD ;
	
	@ManyToOne
	private TurnoverEntity turnover ;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public float getProgress() {
		return progress;
	}

	public void setProgress(float progress) {
		this.progress = progress;
	}

	public float getTurnoverAmount() {
		return turnoverAmount;
	}

	public void setTurnoverAmount(float turnoverAmount) {
		this.turnoverAmount = turnoverAmount;
	}

	public float getRTD() {
		return RTD;
	}

	public void setRTD(float rTD) {
		RTD = rTD;
	}

	public TurnoverEntity getTurnover() {
		return turnover;
	}

	public void setTurnover(TurnoverEntity turnover) {
		this.turnover = turnover;
	}

	public MonthlyTurnoverEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonthlyTurnoverEntity(int month, float progress, float turnoverAmount, float rTD) {
		super();
		this.month = month;
		this.progress = progress;
		this.turnoverAmount = turnoverAmount;
		RTD = rTD;
	}
	
	
	
	
	
}
