package ru.itis.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.models.Student;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
