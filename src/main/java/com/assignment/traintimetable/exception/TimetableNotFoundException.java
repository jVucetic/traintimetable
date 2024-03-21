package com.assignment.traintimetable.exception;

public class TimetableNotFoundException extends RuntimeException {
    public TimetableNotFoundException(Long timetableId) {
        super(String.format("Timetable with id '%s' not found", timetableId.toString()));
    }
}
