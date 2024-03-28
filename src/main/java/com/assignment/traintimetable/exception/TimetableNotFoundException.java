package com.assignment.traintimetable.exception;

import java.util.UUID;

public class TimetableNotFoundException extends RuntimeException {
    public TimetableNotFoundException(UUID timetableId) {
        super(String.format("Timetable with id '%s' not found", timetableId.toString()));
    }
}
