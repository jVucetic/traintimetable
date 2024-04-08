package com.assignment.traintimetable.repository;

import com.assignment.traintimetable.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, UUID> {

    @Query("SELECT t FROM Timetable t WHERE t.departureTime = (SELECT MIN(t2.departureTime) FROM Timetable t2)")
    Timetable findMinimalDepartureTime();
}
