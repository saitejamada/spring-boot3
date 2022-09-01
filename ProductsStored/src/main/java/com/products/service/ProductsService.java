package com.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.model.Bill;
import com.products.model.Category;
import com.products.model.Product;
import com.products.model.Users;
import com.products.repository.BillRepo;
import com.products.repository.CategoryRepo;
import com.products.repository.ProductRepo;
import com.products.repository.UsersRepo;

@Service
public class ProductsService {

	@Autowired
	CategoryRepo cr;
	@Autowired
	ProductRepo pr;
	@Autowired
	UsersRepo ur;
	@Autowired
	BillRepo br;
	
	public void saveUser(Users u) {
		System.out.println(u);
		ur.saveUser(u.getUser_id(),u.getName(),u.getPassword(),u.getType());
	}
	
	public String validateUser(Users u) {
		Users u1=ur.findById(u.getUser_id()).get();
		return u1.getType();
	}
	public void saveCategory(Category c) {
		cr.save(c);
	}
	public void addProducts(Product p) {
		pr.saveProduct(p.getProduct_id(), p.getAvaiable_quantity(), p.getName(), p.getPrice(),p.getCategory().getCategory_id());
		
	}
	public void addBill(Bill b) {
		br.saveBill(b.getBillno(), b.getAmount(), b.getSelect_quantity(),b.getProduct().getProduct_id(),b.getUser().getUser_id());
	}
	public List<Product> getAllProducts(){
		return pr.findAll();
	}
	public Product getProduct(int id) {
		return pr.findById(id).get();
	}
	public void updateProduct(int id,int price) {
		pr.updateProduct(id, price);
	}
	public int getBill(Bill b) {
		return br.updateBill(b.getBillno(),112, 1992);
	}
}
