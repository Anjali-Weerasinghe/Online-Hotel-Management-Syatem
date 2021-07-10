package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
