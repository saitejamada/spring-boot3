package com.invertery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invertery.model.Inventory;
import com.invertery.repository.InventoryRepository;

@Service
public class InventoryService  {
	
	@Autowired
	InventoryRepository ir;
	
	public Inventory saveInventory(Inventory i) {
		return ir.save(i);
	}
	public Inventory getInventory(int id) {
		return ir.findById(id).get();
	}
	public List<Inventory> getAll(){
		return ir.findAll();
	}
	public Inventory getInventoryType(String type) {
		return ir.findBytype(type);
	}
	public Inventory updateInventory(Inventory i) {
		Inventory is=ir.findById(i.getId()).get();
		return ir.save(i);
	}
}
