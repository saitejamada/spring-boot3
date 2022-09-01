package com.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_bloodbank")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String type;
	String description;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Order(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", type=" + type + ", description=" + description + "]";
	}
	
	
}
