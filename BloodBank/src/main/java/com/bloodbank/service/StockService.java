package com.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Stock;
import com.bloodbank.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository sr;
	
	public void saveStock(Stock s) {
		sr.save(s);
	}
	
	public Stock getStock(int id) {
		return sr.findById(id).get();
	}
	
	public List<Stock> getAllStocks(String blood,String type){
		return sr.findByBloodAndType(blood, type);
	}
}
