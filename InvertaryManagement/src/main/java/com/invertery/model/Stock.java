package com.invertery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String decription;
	String stock_number;
	String type;
	String items;
	int price;
	
	public String getStock_number() {
		return stock_number;
	}
	public void setStock_number(String stock_number) {
		this.stock_number = stock_number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getNumber() {
		return stock_number;
	}
	public void setNumber(String number) {
		this.stock_number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	
	public Stock(String decription, String stock_number, String type, String items, int price) {
		super();
		this.decription = decription;
		this.stock_number = stock_number;
		this.type = type;
		this.items = items;
		this.price = price;
	}
	public Stock() {
		super();
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", decription=" + decription + ", stock_number=" + stock_number + ", type=" + type
				+ ", items=" + items + ", price=" + price + "]";
	}
	
	
}
