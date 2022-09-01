package com.invertery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invertery.model.Payment;
import com.invertery.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository pr;
	
	public Payment savePayment(Payment p) {
		return pr.save(p);
	}
	public Payment getPayment(int id) {
		return pr.findById(id).get();
	}
}
