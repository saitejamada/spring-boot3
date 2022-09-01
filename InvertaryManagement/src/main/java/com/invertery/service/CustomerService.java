package com.invertery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invertery.model.Customer;
import com.invertery.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository cr;
	
	public Customer saveCustomer(Customer c) {
		return cr.save(c);
	}
	public Customer getCustomer(int id) {
		return cr.findById(id).get();
	}
}
