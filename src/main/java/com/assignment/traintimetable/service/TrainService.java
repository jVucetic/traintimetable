package com.assignment.traintimetable.service;

import com.assignment.traintimetable.dto.request.BookingRequest;
import com.assignment.traintimetable.model.Train;

import java.util.List;

public interface TrainService {
    List<Train> getAll();

    Train createTrain(Train train);

    Train getTrainById(Long trainId);

    Train updateTrain(Train train);

    void deleteTrain(Long id);

    void book(Long timetableId);
}
