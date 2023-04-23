package ru.itis.school.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.group.GroupDto;
import ru.itis.school.dto.group.GroupPage;
import ru.itis.school.dto.group.NewGroupDto;
import ru.itis.school.models.Group;
import ru.itis.school.models.Teacher;
import ru.itis.school.repositories.GroupRepository;
import ru.itis.school.repositories.TeacherRepository;
import ru.itis.school.services.GroupService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.itis.school.dto.group.GroupDto.from;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public GroupPage getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return GroupPage.builder()
                .groupList(from(groups))
                .build();
    }

    @Override
    public GroupDto createGroup(NewGroupDto newGroup) {
        Optional<Teacher> teacher = teacherRepository.findById(newGroup.getTeacherId());

        Group group = Group.builder()
                .course(newGroup.getCourse())
                .dateInsert(newGroup.getDateInsert())
                .timetables(newGroup.getTimetables())
                .teacher(teacher.get())
                .students(newGroup.getStudents())
                .build();

        groupRepository.save(group);
        return from(group);
    }

    @Override
    public GroupDto findById(UUID id) {
        Optional<Group> group = groupRepository.findById(id);
        return group.map(GroupDto::from).orElse(null);
    }

    @Override
    public GroupDto updateById(GroupDto group) {
        Optional<Group> optionalGroup = groupRepository.findById(group.getId());

        if (optionalGroup.isPresent()) {
            Group groupToUpdate = optionalGroup.get();

            if (group.getCourse() != null) {
                groupToUpdate.setCourse(group.getCourse());
            }

            groupRepository.save(groupToUpdate);
            return from(groupToUpdate);
        } else {
            throw new EntityNotFoundException("Entity with id " + group.getId() + " not found");
        }
    }

    @Override
    public void deleteById(UUID id) {
        groupRepository.deleteById(id);
    }
}
