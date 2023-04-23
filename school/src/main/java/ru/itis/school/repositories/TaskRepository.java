package ru.itis.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.models.Task;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
