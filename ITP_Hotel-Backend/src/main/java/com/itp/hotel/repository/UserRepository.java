package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
