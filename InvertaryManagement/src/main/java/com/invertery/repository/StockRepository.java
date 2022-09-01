package com.invertery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invertery.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
