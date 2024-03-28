package com.assignment.traintimetable.seeder;

import com.assignment.traintimetable.model.Train;
import com.assignment.traintimetable.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@Order(2)
public class TrainSeeder implements CommandLineRunner {

    private final TrainRepository trainRepository;

    @Override
    public void run(String... args) {
        log.info("Inserting train data started");
        insertTestData();
    }

    private void insertTestData() {
        Train train1 = Train.builder()
                .name("Express")
                .capacity(200)
                .description("High-speed train")
                .serialNumber(12345)
                .manufacturer("ABC Trains")
                .build();

        Train train2 = Train.builder()
                .name("Local")
                .capacity(100)
                .description("Commuter train")
                .serialNumber(67890)
                .manufacturer("XYZ Railways")
                .build();

        trainRepository.save(train1);
        trainRepository.save(train2);
    }
}
