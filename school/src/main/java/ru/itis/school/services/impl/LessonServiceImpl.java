package ru.itis.school.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.lesson.LessonDto;
import ru.itis.school.dto.lesson.LessonPage;
import ru.itis.school.dto.lesson.NewLessonDto;
import ru.itis.school.models.Lesson;
import ru.itis.school.models.Timetable;
import ru.itis.school.repositories.LessonRepository;
import ru.itis.school.repositories.TimetableRepository;
import ru.itis.school.services.LessonService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.itis.school.dto.lesson.LessonDto.from;

@RequiredArgsConstructor
@Service
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final TimetableRepository timetableRepository;

    @Override
    public LessonPage getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return LessonPage.builder()
                .lessonList(from(lessons))
                .build();
    }

    @Override
    public LessonDto createLesson(NewLessonDto newLesson) {
        Optional<Timetable> timetable = timetableRepository.findById(newLesson.getTimeTableId());

        Lesson lesson = Lesson.builder()
                .taskList(newLesson.getTaskList())
                .subject(newLesson.getSubject())
                .theme(newLesson.getTheme())
                .timeTable(timetable.get())
                .build();

        lessonRepository.save(lesson);
        return from(lesson);
    }

    @Override
    public LessonDto findById(UUID id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        return lesson.map(LessonDto::from).orElse(null);
    }

    @Override
    public LessonDto updateById(LessonDto lesson) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(lesson.getId());

        if (optionalLesson.isPresent()) {
            Lesson lessonToUpdate = optionalLesson.get();

            if (lessonToUpdate.getSubject() != null) {
                lessonToUpdate.setSubject(lesson.getSubject());
            }

            if (lessonToUpdate.getTheme() != null) {
                lessonToUpdate.setTheme(lessonToUpdate.getTheme());
            }

            lessonRepository.save(lessonToUpdate);
            return from(lessonToUpdate);
        } else {
            throw new EntityNotFoundException("Entity with id " + lesson.getId() + " not found");
        }
    }

    @Override
    public void deleteById(UUID id) {
        lessonRepository.deleteById(id);
    }
}
