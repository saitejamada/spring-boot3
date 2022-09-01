package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
