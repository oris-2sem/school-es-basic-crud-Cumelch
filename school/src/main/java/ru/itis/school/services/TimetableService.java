package ru.itis.school.services;

import ru.itis.school.dto.timetable.NewTimetableDto;
import ru.itis.school.dto.timetable.TimetableDto;
import ru.itis.school.dto.timetable.TimetablePage;

import java.util.UUID;

public interface TimetableService {
    TimetablePage getAllTimetables();
    TimetableDto createTimetable(NewTimetableDto timetable);
    TimetableDto findById(UUID id);
    TimetableDto updateById(TimetableDto timetable);
    void deleteById(UUID id);
}
