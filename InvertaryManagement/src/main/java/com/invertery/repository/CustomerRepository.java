package com.invertery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invertery.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
