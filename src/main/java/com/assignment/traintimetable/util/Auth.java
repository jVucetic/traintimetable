package com.assignment.traintimetable.util;

import com.assignment.traintimetable.exception.UserNotFoundException;
import com.assignment.traintimetable.model.User;
import com.assignment.traintimetable.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Auth {
    private final UserRepository userRepository;
    public User getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException(authentication.getName()));
    }
}
