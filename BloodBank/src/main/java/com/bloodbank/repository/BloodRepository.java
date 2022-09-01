package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.model.Blood;

public interface BloodRepository extends JpaRepository<Blood, Integer>{

}
