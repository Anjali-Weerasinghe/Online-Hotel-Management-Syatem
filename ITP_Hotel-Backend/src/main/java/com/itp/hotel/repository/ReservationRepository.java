package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
