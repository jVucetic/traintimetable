package com.assignment.traintimetable.exception;

import java.util.UUID;

public class TrainNotFoundException extends RuntimeException {
    public TrainNotFoundException(UUID trainId) {
        super(String.format("Train with id '%s' not found", trainId.toString()));
    }
}
