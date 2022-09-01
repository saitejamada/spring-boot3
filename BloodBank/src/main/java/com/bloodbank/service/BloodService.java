package com.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Blood;
import com.bloodbank.repository.BloodRepository;

@Service
public class BloodService {

	@Autowired
	BloodRepository br;
	
	public Blood saveBlood(Blood b) {
		return br.save(b);
	}
	
	public Blood findBlood(int id) {
		return br.findById(id).get();
	}
}
