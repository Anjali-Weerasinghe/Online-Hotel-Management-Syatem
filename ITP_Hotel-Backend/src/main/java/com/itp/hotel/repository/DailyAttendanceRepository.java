package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.DailyAttendance;

public interface DailyAttendanceRepository extends JpaRepository<DailyAttendance,Long> {

}
