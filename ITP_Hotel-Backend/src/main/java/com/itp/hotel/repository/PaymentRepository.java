package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
