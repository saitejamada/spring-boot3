package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
