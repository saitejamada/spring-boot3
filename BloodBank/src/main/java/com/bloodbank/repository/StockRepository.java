package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

	List<Stock> findByBloodAndType(String blood,String type);
}
