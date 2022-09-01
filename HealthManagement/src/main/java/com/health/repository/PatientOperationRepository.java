package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.PatientOperation;

public interface PatientOperationRepository extends JpaRepository<PatientOperation, Integer> {

}
