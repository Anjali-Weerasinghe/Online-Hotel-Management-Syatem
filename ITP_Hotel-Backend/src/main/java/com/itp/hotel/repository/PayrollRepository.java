package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}
