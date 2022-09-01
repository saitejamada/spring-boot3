package com.health.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Operation_theathre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@OneToOne(cascade = CascadeType.ALL)
	PatientOperation po;

	public PatientOperation getPo() {
		return po;
	}

	public void setPo(PatientOperation po) {
		this.po = po;
	}
}
