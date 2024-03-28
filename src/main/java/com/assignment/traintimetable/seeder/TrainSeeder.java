package com.assignment.traintimetable.seeder;

import com.assignment.traintimetable.model.Train;
import com.assignment.traintimetable.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
@Order(2)
public class TrainSeeder implements CommandLineRunner {
    private final TrainRepository trainRepository;
    private static final UUID UUID_1 = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final UUID UUID_2 = UUID.fromString("00000000-0000-0000-0000-000000000002");

    @Override
    public void run(String... args) {
        log.info("Inserting train data started");
        insertTestData();
    }

    private void insertTestData() {
        if (trainRepository.count() == 0) {
            Train train1 = Train.builder()
                    .id(UUID_1)
                    .name("Express")
                    .capacity(200)
                    .description("High-speed train")
                    .serialNumber(12345)
                    .manufacturer("ABC Trains")
                    .build();

            Train train2 = Train.builder()
                    .id(UUID_2)
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
}
