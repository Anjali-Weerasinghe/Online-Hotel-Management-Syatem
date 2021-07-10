package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.PurchasedItemDetail;

public interface PurchasedItemDetailRepository extends JpaRepository<PurchasedItemDetail, Integer> {

}
