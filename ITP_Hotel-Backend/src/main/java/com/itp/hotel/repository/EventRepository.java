package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
