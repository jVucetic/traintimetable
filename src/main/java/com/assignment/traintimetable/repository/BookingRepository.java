package com.assignment.traintimetable.repository;

import com.assignment.traintimetable.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
