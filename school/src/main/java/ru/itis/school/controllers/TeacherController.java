package ru.itis.school.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.ModelId;
import ru.itis.school.dto.teacher.NewTeacherDto;
import ru.itis.school.dto.teacher.TeacherDto;
import ru.itis.school.dto.teacher.TeacherPage;
import ru.itis.school.services.TeacherService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public TeacherPage getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/id")
    public TeacherDto findById(@RequestParam("id") UUID id) {
        return teacherService.findById(id);
    }

    @PostMapping("/create")
    public TeacherDto createTeacher(@RequestBody NewTeacherDto newTeacherDto) {
        return teacherService.createTeacher(newTeacherDto);
    }

    @PostMapping("/update")
    public TeacherDto updateById(@RequestBody TeacherDto teacherDto) {
        return teacherService.updateById(teacherDto);
    }

    @PostMapping("/del")
    public UUID deleteById(@RequestBody ModelId id) {
        teacherService.deleteById(id.getId());
        return id.getId();
    }

}
