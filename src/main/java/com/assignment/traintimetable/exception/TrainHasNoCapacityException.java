package com.assignment.traintimetable.exception;

import java.util.UUID;

public class TrainHasNoCapacityException extends RuntimeException {
    public TrainHasNoCapacityException(UUID trainId) {
        super(String.format("Train with id '%s' doesn't have enough capacity", trainId.toString()));
    }
}
