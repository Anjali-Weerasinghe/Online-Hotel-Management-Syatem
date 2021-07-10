package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.OrderMenuItem;

public interface OrderMenuItemRepository extends JpaRepository<OrderMenuItem, Long> {

}
