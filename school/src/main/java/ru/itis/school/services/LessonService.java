package ru.itis.school.services;

import ru.itis.school.dto.lesson.LessonDto;
import ru.itis.school.dto.lesson.LessonPage;
import ru.itis.school.dto.lesson.NewLessonDto;

import java.util.UUID;

public interface LessonService {
    LessonPage getAllLessons();
    LessonDto createLesson(NewLessonDto lesson);
    LessonDto findById(UUID id);
    LessonDto updateById(LessonDto lesson);
    void deleteById(UUID id);
}
