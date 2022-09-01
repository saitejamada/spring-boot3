package com.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Donor;
import com.bloodbank.repository.DonorRepository;

@Service
public class DonorService {

	@Autowired
	DonorRepository dr;
	
	public Donor saveDonor(Donor d) {
		return dr.save(d);
	}
	public Donor findDonor(int id) {
		return dr.findById(id).get();
	}
	
}
