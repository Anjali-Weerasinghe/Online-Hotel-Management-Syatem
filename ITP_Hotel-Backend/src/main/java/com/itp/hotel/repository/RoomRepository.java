package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
