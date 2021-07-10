package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
