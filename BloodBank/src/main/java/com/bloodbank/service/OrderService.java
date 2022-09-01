package com.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Order;
import com.bloodbank.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository or;
	
	public Order saveOrder(Order o) {
		return or.save(o);
	}
	
	public Order getOrder(int id) {
		return or.findById(id).get();
	}
}
