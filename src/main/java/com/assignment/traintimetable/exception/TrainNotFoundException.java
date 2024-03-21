package com.assignment.traintimetable.exception;

public class TrainNotFoundException extends RuntimeException {
    public TrainNotFoundException(Long trainId) {
        super(String.format("Train with id '%s' not found", trainId.toString()));
    }
}
