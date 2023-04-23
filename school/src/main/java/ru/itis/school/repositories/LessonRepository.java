package ru.itis.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.models.Lesson;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {
}
