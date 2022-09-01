package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.Surgeon;

public interface SurgeonRepository extends JpaRepository<Surgeon, Integer> {

}
