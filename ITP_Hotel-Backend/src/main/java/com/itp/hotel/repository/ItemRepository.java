package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
