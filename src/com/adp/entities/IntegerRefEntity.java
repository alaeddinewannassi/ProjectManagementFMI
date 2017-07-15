package com.adp.entities;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public class IntegerRefEntity extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int p;

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}
	
	
}
