package ru.itis.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.models.Parent;

import java.util.UUID;

public interface ParentRepository extends JpaRepository<Parent, UUID> {
}
