package com.adp.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FMI_INTERESTS")
public class InterestEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String interestName;

	public String getInterestName() {
		return interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}

	public InterestEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InterestEntity(String interestName) {
		super();
		this.interestName = interestName;
	}

}
