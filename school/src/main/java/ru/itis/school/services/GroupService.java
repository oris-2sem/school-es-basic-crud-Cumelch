package ru.itis.school.services;

import ru.itis.school.dto.group.GroupDto;
import ru.itis.school.dto.group.GroupPage;
import ru.itis.school.dto.group.NewGroupDto;

import java.util.UUID;

public interface GroupService {
    GroupPage getAllGroups();
    GroupDto createGroup(NewGroupDto group);
    GroupDto findById(UUID id);
    GroupDto updateById(GroupDto group);
    void deleteById(UUID id);
}
