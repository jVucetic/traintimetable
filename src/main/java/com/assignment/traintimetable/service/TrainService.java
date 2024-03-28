package com.assignment.traintimetable.service;

import com.assignment.traintimetable.model.Train;

import java.util.List;
import java.util.UUID;

public interface TrainService {
    List<Train> getAll();

    Train createTrain(Train train);

    Train getTrainById(UUID trainId);

    Train updateTrain(Train train);

    void deleteTrain(UUID id);

    void book(UUID timetableId);
}
