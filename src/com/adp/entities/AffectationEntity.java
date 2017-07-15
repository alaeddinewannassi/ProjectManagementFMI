package com.adp.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionOfElements;

@Entity
@Table(name="FMI_AFFECTATION")
public class AffectationEntity extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(targetEntity=ThirdPartyEntity.class,fetch=FetchType.EAGER)
    @JoinColumn(name = "thirdPartyId",nullable = false) 
	private ThirdPartyEntity thirdParty ;
	
	
	@ManyToOne(targetEntity=MissionEntity.class,fetch=FetchType.EAGER)
    @JoinColumn(name = "missionId",nullable = false) 
	private MissionEntity mission ; 
	 
	@CollectionOfElements
	private Collection<Integer> month ;
	
	 @Column(name = "REGISTERED_DATE")
	    @Temporal(TemporalType.DATE)
	private Date affectationDate ;

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


	public Collection<Integer> getMonth() {
		return month;
	}

	public void setMonth(Collection<Integer> month) {
		this.month = month;
	}

	public Date getAffectationDate() {
		return affectationDate;
	}

	public void setAffectationDate(Date affectationDate) {
		this.affectationDate = affectationDate;
	}
	 
	 
	
	
	
	
	
	
}
