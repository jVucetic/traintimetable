package com.assignment.traintimetable.seeder;

import com.assignment.traintimetable.model.Booking;
import com.assignment.traintimetable.model.Timetable;
import com.assignment.traintimetable.model.User;
import com.assignment.traintimetable.repository.BookingRepository;
import com.assignment.traintimetable.repository.TimetableRepository;
import com.assignment.traintimetable.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
@Order(4)
public class BookingSeeder implements CommandLineRunner {
    private final TimetableRepository timetableRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    @Override
    public void run(String... args) {
        log.info("Inserting timetable data started");
        insertTestData();
    }

    private void insertTestData() {
        Timetable timetable1 = timetableRepository.findById(UUID.fromString("00000000-0000-0000-0000-000000000001")).orElseThrow();
        Timetable timetable2 = timetableRepository.findById(UUID.fromString("00000000-0000-0000-0000-000000000002")).orElseThrow();

        User user1 = userRepository.findById(UUID.fromString("00000000-0000-0000-0000-000000000001")).orElseThrow();
        User user2 = userRepository.findById(UUID.fromString("00000000-0000-0000-0000-000000000002")).orElseThrow();

        Booking booking1 = Booking.builder()
                .user(user1)
                .timetable(timetable1)
                .build();

        Booking booking2 = Booking.builder()
                .user(user2)
                .timetable(timetable2)
                .build();

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
    }
}
