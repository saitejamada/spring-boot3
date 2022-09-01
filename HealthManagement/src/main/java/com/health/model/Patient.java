package com.health.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String type_of_treatment;
	@OneToOne(cascade = CascadeType.ALL)
	Ward ward;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType_of_treatment() {
		return type_of_treatment;
	}
	public void setType_of_treatment(String type_of_treatment) {
		this.type_of_treatment = type_of_treatment;
	}
	public Ward getWard() {
		return ward;
	}
	public void setWard(Ward ward) {
		this.ward = ward;
	}
}
