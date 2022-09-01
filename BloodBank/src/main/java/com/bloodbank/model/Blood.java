package com.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blood_bloodbank")
public class Blood {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String bloodgroup;
	String type;
	String bank;
	@OneToOne(cascade = CascadeType.MERGE)
	Donor donor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	public String getGroup() {
		return bloodgroup;
	}
	public void setGroup(String group) {
		this.bloodgroup = group;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Blood(String bloodgroup, String type, String bank, Donor donor) {
		super();
		this.bloodgroup = bloodgroup;
		this.type = type;
		this.bank = bank;
		this.donor = donor;
	}
	public Blood() {
		super();
	}
	@Override
	public String toString() {
		return "Blood [id=" + id + ", bloodgroup=" + bloodgroup + ", type=" + type + ", bank=" + bank + ", donor="
				+ donor + "]";
	}
	
	
}
