package ru.itis.school.services;

import ru.itis.school.dto.teacher.NewTeacherDto;
import ru.itis.school.dto.teacher.TeacherDto;
import ru.itis.school.dto.teacher.TeacherPage;

import java.util.UUID;

public interface TeacherService {
    TeacherPage getAllTeachers();
    TeacherDto createTeacher(NewTeacherDto teacher);
    TeacherDto findById(UUID id);
    TeacherDto updateById(TeacherDto teacher);
    void deleteById(UUID id);
}
