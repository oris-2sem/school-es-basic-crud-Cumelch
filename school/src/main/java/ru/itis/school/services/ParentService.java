package ru.itis.school.services;

import ru.itis.school.dto.parent.NewParentDto;
import ru.itis.school.dto.parent.ParentDto;
import ru.itis.school.dto.parent.ParentPage;

import java.util.UUID;

public interface ParentService {
    ParentPage getAllParents();
    ParentDto createParent(NewParentDto parent);
    ParentDto findById(UUID id);
    ParentDto updateById(ParentDto parent);
    void deleteById(UUID id);
}
