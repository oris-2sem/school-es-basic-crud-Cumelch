package ru.itis.school.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.ModelId;
import ru.itis.school.dto.timetable.NewTimetableDto;
import ru.itis.school.dto.timetable.TimetableDto;
import ru.itis.school.dto.timetable.TimetablePage;
import ru.itis.school.services.TimetableService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timetable")
public class TimetableController {
    private final TimetableService timetableService;

    @GetMapping
    public TimetablePage getAllTimetables() {
        return timetableService.getAllTimetables();
    }

    @GetMapping("/id")
    public TimetableDto findById(@RequestParam("id") UUID id) {
        return timetableService.findById(id);
    }

    @PostMapping("/create")
    public TimetableDto createTeacher(@RequestBody NewTimetableDto newTimetableDto) {
        return timetableService.createTimetable(newTimetableDto);
    }

    @PostMapping("/update")
    public TimetableDto updateById(@RequestBody TimetableDto timetableDto) {
        return timetableService.updateById(timetableDto);
    }

    @PostMapping("/del")
    public UUID deleteById(@RequestBody ModelId id) {
        timetableService.deleteById(id.getId());
        return id.getId();
    }



}
