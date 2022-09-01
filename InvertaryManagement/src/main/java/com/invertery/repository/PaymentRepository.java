package com.invertery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invertery.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
