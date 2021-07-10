package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.BarroomOrder;

public interface BarroomOrderRepository extends JpaRepository<BarroomOrder, Long> {

}
