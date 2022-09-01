package com.health.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PatientOperation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String cost_of_operation;
	@OneToOne(cascade = CascadeType.ALL)
	Operation_theathre ot;
	@OneToOne(cascade = CascadeType.ALL)
	Surgeon sur;
	@OneToOne(cascade = CascadeType.ALL)
	Patient p;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCost_of_operation() {
		return cost_of_operation;
	}
	public void setCost_of_operation(String cost_of_operation) {
		this.cost_of_operation = cost_of_operation;
	}
	
	public Operation_theathre getOt() {
		return ot;
	}
	public void setOt(Operation_theathre ot) {
		this.ot = ot;
	}
	public Surgeon getSur() {
		return sur;
	}
	public void setSur(Surgeon sur) {
		this.sur = sur;
	}
	public Patient getP() {
		return p;
	}
	public void setP(Patient p) {
		this.p = p;
	}
}
