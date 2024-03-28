package com.assignment.traintimetable.seeder;

import com.assignment.traintimetable.model.Timetable;
import com.assignment.traintimetable.model.Train;
import com.assignment.traintimetable.repository.TimetableRepository;
import com.assignment.traintimetable.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
@Order(3)
public class TimetableSeeder implements CommandLineRunner {

    private final TimetableRepository timetableRepository;
    private final TrainRepository trainRepository;

    @Override
    public void run(String... args) {
        log.info("Inserting timetable data started");
        insertTestData();
    }

    private void insertTestData() {
        Train train1 = trainRepository.findById(UUID.fromString("00000000-0000-0000-0000-000000000001")).orElseThrow();
        Train train2 = trainRepository.findById(UUID.fromString("00000000-0000-0000-0000-000000000002")).orElseThrow();

        Timetable timetable1 = Timetable.builder()
                .fromLocation("New York")
                .toLocation("Chicago")
                .departureTime(LocalDateTime.parse("2024-03-21T08:00:00"))
                .arrivalTime(LocalDateTime.parse("2024-03-21T12:00:00"))
                .train(train1)
                .build();

        Timetable timetable2 = Timetable.builder()
                .fromLocation("Chicago")
                .toLocation("Los Angeles")
                .departureTime(LocalDateTime.parse("2024-03-21T13:00:00"))
                .arrivalTime(LocalDateTime.parse("2024-03-21T18:00:00"))
                .train(train2)
                .build();

        timetableRepository.save(timetable1);
        timetableRepository.save(timetable2);
    }
}