package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
