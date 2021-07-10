package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
