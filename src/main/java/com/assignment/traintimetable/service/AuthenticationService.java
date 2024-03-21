package com.assignment.traintimetable.service;

import com.assignment.traintimetable.dto.request.SignUpRequest;
import com.assignment.traintimetable.dto.request.SigninRequest;
import com.assignment.traintimetable.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
