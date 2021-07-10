package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.FoodDetails;

public interface FoodDetailsRepository extends JpaRepository<FoodDetails, Integer> {

}
