package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.MonthlyAttendance;

public interface MonthlyAttendanceRepository extends JpaRepository<MonthlyAttendance, Long> {

}
