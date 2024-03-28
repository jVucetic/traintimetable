package com.assignment.traintimetable.controller;

import com.assignment.traintimetable.model.Train;
import com.assignment.traintimetable.service.impl.TrainServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/trains")
@RequiredArgsConstructor
public class TrainController {
    private final TrainServiceImpl trainService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Train>> getTrains() {
        List<Train> trains = trainService.getAll();

        return ResponseEntity.ok(trains);
    }

    @PostMapping
    public ResponseEntity<Train> createTrain(@RequestBody Train train) {
        Train newTrain = trainService.createTrain(train);

        return ResponseEntity.status(HttpStatus.CREATED).body(newTrain);
    }

    @GetMapping("{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable("id") UUID trainId) {
        Train train = trainService.getTrainById(trainId);

        return ResponseEntity.ok(train);
    }

    @PutMapping("{id}")
    public ResponseEntity<Train> updateTrain(@PathVariable("id") UUID trainId,
                                             @RequestBody Train train) {
        Train updatedTrain = trainService.updateTrain(train);
        return ResponseEntity.ok(updatedTrain);
    }

    @DeleteMapping("{id}")
    public void deleteTrain(@PathVariable("id") UUID trainId) {
        trainService.deleteTrain(trainId);
    }

    @PostMapping("/timetable/{timetableId}/book")
    public void book(@PathVariable("timetableId") UUID timetableId) {
        trainService.book(timetableId);
    }

}
