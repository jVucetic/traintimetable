package com.assignment.traintimetable.seeder;

import com.assignment.traintimetable.enums.Role;
import com.assignment.traintimetable.model.User;
import com.assignment.traintimetable.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
@Order(1)
public class UserSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        log.info("inserting user data started");
        insertTestData();
    }

    private void insertTestData() {
        if (userRepository.count() == 0) {
            User user1 = User.builder()
                    .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
                    .firstName("John")
                    .lastName("Doe")
                    .email("john@example.com")
                    .password(passwordEncoder.encode("password123"))
                    .role(Role.USER)
                    .build();


            User user2 = User.builder()
                    .id(UUID.fromString("00000000-0000-0000-0000-000000000002"))
                    .firstName("Alice")
                    .lastName("Smith")
                    .email("alice@example.com")
                    .password(passwordEncoder.encode("password456"))
                    .role(Role.ADMIN)
                    .build();

            userRepository.save(user1);
            userRepository.save(user2);
        }

    }
}
