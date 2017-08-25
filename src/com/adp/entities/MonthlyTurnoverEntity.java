package com.adp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FMI_MONTHLY_TURNOVER")
public class MonthlyTurnoverEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int month;

	private float progress;

	private float turnoverAmount;

	private float actual;

	private float realRTD;

	private Date referenceDate; // import date ( timesheet )

	@ManyToOne
	@JoinColumn(name="turnover_id")
	private TurnoverEntity turnover;

	public float getActual() {
		return actual;
	}

	public void setActual(float actual) {
		this.actual = actual;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

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

	public float getRealRTD() {
		return realRTD;
	}

	public void setRealRTD(float realRTD) {
		this.realRTD = realRTD;
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

	public MonthlyTurnoverEntity(Date referenceDate,int month, float progress, float turnoverAmount, float rTD) {
		super();
		this.referenceDate = referenceDate;
		this.month = month;
		this.progress = progress;
		this.turnoverAmount = turnoverAmount;
		this.realRTD = rTD;
	}

}
