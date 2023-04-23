package ru.itis.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.models.Group;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
