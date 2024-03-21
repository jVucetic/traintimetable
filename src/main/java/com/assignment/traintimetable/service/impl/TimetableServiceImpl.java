package com.assignment.traintimetable.service.impl;

import com.assignment.traintimetable.dto.request.TimetableRequestDto;
import com.assignment.traintimetable.model.Timetable;
import com.assignment.traintimetable.model.Train;
import com.assignment.traintimetable.repository.TimetableRepository;
import com.assignment.traintimetable.repository.TrainRepository;
import com.assignment.traintimetable.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableServiceImpl implements TimetableService {
    private final TimetableRepository timetableRepository;
    private final TrainRepository trainRepository;
    @Override
    public List<Timetable> getAll() {
        return timetableRepository.findAll();
    }

    @Override
    public Timetable createTimetable(TimetableRequestDto dto) {
        Train train = trainRepository.findById(dto.getTrainId()).orElseThrow();

        Timetable timetable = Timetable.builder()
                .toLocation(dto.getToLocation())
                .fromLocation(dto.getFromLocation())
                .arrivalTime(dto.getArrivalTime())
                .departureTime(dto.getDepartureTime())
                .train(train)
                .build();
        return timetableRepository.save(timetable);
    }

    @Override
    public Timetable getTimetableById(Long timetableId) {
        return timetableRepository.findById(timetableId).orElseThrow();
    }

    @Override
    public Timetable updateTimetable(Timetable timetable) {
        Timetable existingTimetable = timetableRepository.findById(timetable.getId()).orElseThrow();
        existingTimetable.setArrivalTime(timetable.getArrivalTime());
        existingTimetable.setDepartureTime(timetable.getArrivalTime());
        existingTimetable.setFromLocation(timetable.getFromLocation());
        existingTimetable.setToLocation(timetable.getToLocation());
        return timetableRepository.save(existingTimetable);
    }

    @Override
    public void deleteTimetable(Long timetableId) {
        timetableRepository.deleteById(timetableId);
    }
}
