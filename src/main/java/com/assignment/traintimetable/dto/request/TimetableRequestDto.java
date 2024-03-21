package com.assignment.traintimetable.dto.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class TimetableRequestDto {
    private String fromLocation;
    private String toLocation;
    private Date departureTime;
    private Date arrivalTime;
    private Long trainId;
}
