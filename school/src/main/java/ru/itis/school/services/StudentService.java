package ru.itis.school.services;

import ru.itis.school.dto.student.NewStudentDto;
import ru.itis.school.dto.student.StudentDto;
import ru.itis.school.dto.student.StudentPage;

import java.util.UUID;

public interface StudentService {
    StudentPage getAllStudents();
    StudentDto createStudent(NewStudentDto student);
    StudentDto findById(UUID id);
    StudentDto updateById(StudentDto student);
    void deleteById(UUID id);
}
