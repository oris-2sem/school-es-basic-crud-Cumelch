package ru.itis.school.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.ModelId;
import ru.itis.school.dto.group.GroupDto;
import ru.itis.school.dto.group.GroupPage;
import ru.itis.school.dto.group.NewGroupDto;
import ru.itis.school.services.GroupService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public GroupPage getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/id")
    public GroupDto findById(@RequestParam("id") UUID id) {
        return groupService.findById(id);
    }

    @PostMapping("/create")
    public GroupDto createGroup(@RequestBody NewGroupDto newGroupDto) {
        return groupService.createGroup(newGroupDto);
    }

    @PostMapping("/update")
    public GroupDto updateById(@RequestBody GroupDto groupDto) {
        return groupService.updateById(groupDto);
    }

    @PostMapping("/del")
    public UUID deleteById(@RequestBody ModelId id) {
        groupService.deleteById(id.getId());
        return id.getId();
    }
}
