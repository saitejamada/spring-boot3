package com.invertery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invertery.model.Inventory;

public interface InventoryRepository  extends JpaRepository<Inventory, Integer>{

	Inventory findBytype(String type);

}
