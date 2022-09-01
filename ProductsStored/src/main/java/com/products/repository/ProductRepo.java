package com.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.products.model.Category;
import com.products.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Procedure("insert_product")
	public void saveProduct(int product_id,int avaiable_quantity,String name,int price,int category_id);
	
	@Procedure("update_price")
	public void updateProduct(int pid,int pri);
}
