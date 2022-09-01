package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.Nurses;

public interface NursesRepository extends JpaRepository<Nurses, Integer> {

}
