package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.BevOrder;

public interface BevOrderRepository extends JpaRepository<BevOrder,Long> {

}
