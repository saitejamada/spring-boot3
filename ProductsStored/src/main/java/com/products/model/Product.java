package com.products.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "product")
public class Product {

	@Id
	int product_id;
	String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	Category category;
	int avaiable_quantity;
	int price;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getAvaiable_quantity() {
		return avaiable_quantity;
	}
	public void setAvaiable_quantity(int avaiable_quantity) {
		this.avaiable_quantity = avaiable_quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", category=" + category
				+ ", avaiable_quantity=" + avaiable_quantity + ", price=" + price + "]";
	}
	
	
}
