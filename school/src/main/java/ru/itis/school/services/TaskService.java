package ru.itis.school.services;

import ru.itis.school.dto.task.NewTaskDto;
import ru.itis.school.dto.task.TaskDto;
import ru.itis.school.dto.task.TaskPage;

import java.util.UUID;

public interface TaskService {
    TaskPage getAllTasks();
    TaskDto createTask(NewTaskDto task);
    TaskDto findById(UUID id);
    TaskDto updateById(TaskDto task);
    void deleteById(UUID id);
}
