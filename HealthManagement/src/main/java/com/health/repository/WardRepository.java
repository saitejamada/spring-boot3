package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.Ward;

public interface WardRepository extends JpaRepository<Ward, Integer>{

}
