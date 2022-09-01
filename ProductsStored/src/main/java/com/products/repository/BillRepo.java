package com.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.products.model.Bill;

public interface BillRepo extends JpaRepository<Bill, Integer> {

	@Procedure("insert_bill")
	public void saveBill(int billno,
			int amount,
			int select_quantity,
			int product_id,
			int user_id);
	
	@Procedure("update_bill")
	public int updateBill(int bno,int pid,int userid);
	
}
