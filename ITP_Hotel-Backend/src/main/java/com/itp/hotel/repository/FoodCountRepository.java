package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.FoodCount;

public interface FoodCountRepository extends JpaRepository<FoodCount, Integer> {

}
