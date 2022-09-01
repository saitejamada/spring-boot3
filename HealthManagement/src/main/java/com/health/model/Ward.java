package com.health.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Ward {

	@Id
	int ward_no;
	String patient_admitted;
	String nurse_assigned;
	@OneToMany(cascade = CascadeType.ALL)
	List<Nurses> nurse;
	public List<Nurses> getNurse() {
		return nurse;
	}
	public void setNurse(List<Nurses> nurse) {
		this.nurse = nurse;
	}
	public int getWard_no() {
		return ward_no;
	}
	public void setWard_no(int ward_no) {
		this.ward_no = ward_no;
	}
	public String getPatient_admitted() {
		return patient_admitted;
	}
	public void setPatient_admitted(String patient_admitted) {
		this.patient_admitted = patient_admitted;
	}
	public String getNurse_assigned() {
		return nurse_assigned;
	}
	public void setNurse_assigned(String nurse_assigned) {
		this.nurse_assigned = nurse_assigned;
	}
	
}
