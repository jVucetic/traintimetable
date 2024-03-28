package com.assignment.traintimetable.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class TimetableRequestDto {
    private UUID trainId;
    private String fromLocation;
    private String toLocation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
