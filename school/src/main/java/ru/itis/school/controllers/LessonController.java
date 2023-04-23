package ru.itis.school.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.ModelId;
import ru.itis.school.dto.lesson.LessonDto;
import ru.itis.school.dto.lesson.LessonPage;
import ru.itis.school.dto.lesson.NewLessonDto;
import ru.itis.school.services.LessonService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;

    @GetMapping
    public LessonPage getAllTeachers() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/id")
    public LessonDto findById(@RequestParam("id") UUID id) {
        return lessonService.findById(id);
    }

    @PostMapping("/create")
    public LessonDto createStudent(@RequestBody NewLessonDto newLessonDto) {
        return lessonService.createLesson(newLessonDto);
    }

    @PostMapping("/update")
    public LessonDto updateById(@RequestBody LessonDto lessonDto) {
        return lessonService.updateById(lessonDto);
    }

    @PostMapping("/del")
    public UUID deleteById(@RequestBody ModelId id) {
        lessonService.deleteById(id.getId());
        return id.getId();
    }
}
