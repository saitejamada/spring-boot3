package com.products.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill {

	@Id
	int billno;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	Users user;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	Product product;
	int select_quantity;
	int amount;
	
	public int getBillno() {
		return billno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user= user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getSelect_quantity() {
		return select_quantity;
	}
	public void setSelect_quantity(int select_quantity) {
		this.select_quantity = select_quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Bill [billno=" + billno + ", user=" + user + ", product=" + product + ", select_quantity="
				+ select_quantity + ", amount=" + amount + "]";
	}
	
}
