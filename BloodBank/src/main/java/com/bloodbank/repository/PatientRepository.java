package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
