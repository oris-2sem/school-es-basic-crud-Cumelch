package ru.itis.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.models.Timetable;

import java.util.UUID;

public interface TimetableRepository extends JpaRepository<Timetable, UUID> {
}
