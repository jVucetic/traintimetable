package com.assignment.traintimetable.controller;


import com.assignment.traintimetable.dto.request.TimetableRequestDto;
import com.assignment.traintimetable.model.Timetable;
import com.assignment.traintimetable.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/timetables")
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;

    @GetMapping
    public ResponseEntity<List<Timetable>> getTimetables() {
        List<Timetable> Timetables = timetableService.getAll();

        return ResponseEntity.ok(Timetables);
    }

    @PostMapping
    public ResponseEntity<Timetable> createTimetable(@RequestBody TimetableRequestDto timetable) {
        Timetable newTimetable = timetableService.createTimetable(timetable);

        return ResponseEntity.status(HttpStatus.CREATED).body(newTimetable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Timetable> getTimetableById(@PathVariable("id") Long timetableId) {
        Timetable Timetable = timetableService.getTimetableById(timetableId);

        return ResponseEntity.ok(Timetable);
    }

    @PutMapping("{id}")
    public ResponseEntity<Timetable> updateTimetable(@PathVariable("id") Long timetableId,
                                             @RequestBody Timetable timetable) {
        Timetable updatedTimetable = timetableService.updateTimetable(timetable);
        return ResponseEntity.ok(updatedTimetable);
    }

    @DeleteMapping("{id}")
    public void deleteTimetable(@PathVariable("id") Long TimetableId) {
        timetableService.deleteTimetable(TimetableId);
    }
}
