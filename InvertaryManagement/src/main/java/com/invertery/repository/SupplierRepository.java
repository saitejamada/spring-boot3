package com.invertery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invertery.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

	Supplier findByusername(String name);

}
