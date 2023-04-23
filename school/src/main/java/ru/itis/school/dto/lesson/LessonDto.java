package ru.itis.school.dto.lesson;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import ru.itis.school.dto.task.TaskDto;
import ru.itis.school.models.Lesson;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDto {
    private UUID id;
    private UUID timeTableId;
    private String theme;
    private String subject;
    private List<TaskDto> taskList;

    public static LessonDto from(Lesson lesson) {
        return LessonDto.builder()
                .id(lesson.getId())
                .theme(lesson.getTheme())
                .subject(lesson.getSubject())
                .timeTableId(lesson.getTimeTable().getId())
                .taskList(TaskDto.from(lesson.getTaskList()))
                .build();
    }

    public static List<LessonDto> from(List<Lesson> lessons) {
        if (CollectionUtils.isEmpty(lessons)) { return null; }

        return lessons
                .stream()
                .map(LessonDto::from)
                .collect(Collectors.toList());
    }
}
