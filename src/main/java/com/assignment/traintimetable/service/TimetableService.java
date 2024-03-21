package com.assignment.traintimetable.service;

import com.assignment.traintimetable.dto.request.TimetableRequestDto;
import com.assignment.traintimetable.model.Timetable;

import java.util.List;

public interface TimetableService {
    List<Timetable> getAll();

    Timetable createTimetable(TimetableRequestDto timetable);

    Timetable getTimetableById(Long timetableId);

    Timetable updateTimetable(Timetable timetable);

    void deleteTimetable(Long id);
}
