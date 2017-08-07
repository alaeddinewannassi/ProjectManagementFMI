package com.adp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="FMI_AFFECTATION")
public class AffectationEntity extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    @JoinColumn(name = "thirdPartyId",nullable = false) 
	private ThirdPartyEntity thirdParty ;
	
	
	@ManyToOne
    @JoinColumn(name = "missionId",nullable = false) 
	private MissionEntity mission ; 
	 
	@Temporal(TemporalType.DATE)
	private Date startDate ;
	
	@Temporal(TemporalType.DATE)
	private Date endDate ;
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ThirdPartyEntity getThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(ThirdPartyEntity thirdParty) {
		this.thirdParty = thirdParty;
	}

	public MissionEntity getMission() {
		return mission;
	}

	public void setMission(MissionEntity mission) {
		this.mission = mission;
	}

	public AffectationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AffectationEntity(ThirdPartyEntity thirdParty, MissionEntity mission, Date startDate, Date endDate) {
		super();
		this.thirdParty = thirdParty;
		this.mission = mission;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
	


	
	 
	
	
	
	
	
	
}