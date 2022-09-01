package com.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock_bloodbank")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String blood;
	String type;
	String stocknumber;
	@OneToOne(cascade = CascadeType.MERGE)
	Permission permission;
	
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStocknumber() {
		return stocknumber;
	}
	public void setStocknumber(String stocknumber) {
		this.stocknumber = stocknumber;
	}
	public Stock() {
		super();
	}
	public Stock(String blood, String type, String stocknumber, Permission permission) {
		super();
		this.blood = blood;
		this.type = type;
		this.stocknumber = stocknumber;
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", blood=" + blood + ", type=" + type + ", stocknumber=" + stocknumber
				+ ", permission=" + permission + "]";
	}
	
}



















