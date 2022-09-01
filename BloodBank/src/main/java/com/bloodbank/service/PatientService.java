package com.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Patient;
import com.bloodbank.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository pr;
	
	public Patient savePatient(Patient p) {
		return pr.save(p);
	}
	
	public Patient getPatient(int id) {
		return pr.findById(id).get();
	}
}
