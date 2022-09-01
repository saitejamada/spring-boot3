package com.health.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Hosipatal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String place;
	@OneToMany(cascade = CascadeType.ALL)
	List<Ward>	 ward;
	@OneToMany(cascade = CascadeType.ALL)
	List<Nurses>	 nurse;
	@OneToMany(cascade = CascadeType.ALL)
	List<Operation_theathre>	 ot;
	@OneToMany(cascade = CascadeType.ALL)
	List<Surgeon>	 sur;
	@OneToMany(cascade = CascadeType.ALL)
	List<Patient>	 ps;
	@OneToMany(cascade = CascadeType.ALL)
	List<PatientOperation>	 po;
	
	public List<Ward> getWard() {
		return ward;
	}
	public void setWard(List<Ward> ward) {
		this.ward = ward;
	}
	public List<Nurses> getNurse() {
		return nurse;
	}
	public void setNurse(List<Nurses> nurse) {
		this.nurse = nurse;
	}
	public List<Operation_theathre> getOt() {
		return ot;
	}
	public void setOt(List<Operation_theathre> ot) {
		this.ot = ot;
	}
	public List<Surgeon> getSur() {
		return sur;
	}
	public void setSur(List<Surgeon> sur) {
		this.sur = sur;
	}
	public List<Patient> getPs() {
		return ps;
	}
	public void setPs(List<Patient> ps) {
		this.ps = ps;
	}
	public List<PatientOperation> getPo() {
		return po;
	}
	public void setPo(List<PatientOperation> po) {
		this.po = po;
	}
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
}
