package com.assignment.traintimetable.service.impl;

import com.assignment.traintimetable.exception.TimetableNotFoundException;
import com.assignment.traintimetable.exception.TrainNotFoundException;
import com.assignment.traintimetable.model.Booking;
import com.assignment.traintimetable.model.Timetable;
import com.assignment.traintimetable.model.Train;
import com.assignment.traintimetable.model.User;
import com.assignment.traintimetable.repository.BookingRepository;
import com.assignment.traintimetable.repository.TimetableRepository;
import com.assignment.traintimetable.repository.TrainRepository;
import com.assignment.traintimetable.service.TrainService;
import com.assignment.traintimetable.util.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainRepository;
    private final TimetableRepository timetableRepository;
    private final Auth auth;
    private final BookingRepository bookingRepository;

    @Override
    public List<Train> getAll() {
        return trainRepository.findAll();
    }

    @Override
    public Train createTrain(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public Train getTrainById(UUID trainId) {
        return trainRepository.findById(trainId).orElseThrow(() -> new TrainNotFoundException(trainId));
    }

    @Override
    public Train updateTrain(Train train) {
        Train existingTrain = trainRepository.findById(train.getId())
                .orElseThrow(() -> new TrainNotFoundException(train.getId()));
        existingTrain.setCapacity(train.getCapacity());
        existingTrain.setDescription(train.getDescription());
        existingTrain.setName(train.getName());
        existingTrain.setManufacturer(train.getManufacturer());
        return trainRepository.save(existingTrain);
    }

    @Override
    public void deleteTrain(UUID trainId) {
        trainRepository.deleteById(trainId);
    }

    @Override
    public void book(UUID timetableId) {
        Timetable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() -> new TimetableNotFoundException(timetableId));
        User user = auth.getPrincipal();

        

        boolean isReserved = false;
        //if exist departure time earlier than passed save a reservation
        Timetable firstDeparture = timetableRepository.findMinimalDepartureTime();
        if ( firstDeparture.getDepartureTime().isBefore(timetable.getDepartureTime())) {
            isReserved = true;
        }

        Booking booking = Booking.builder()
                .user(user)
                .timetable(timetable)
                .isReserved(isReserved)
                .build();


        bookingRepository.save(booking);
    }
}
