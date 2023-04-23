package ru.itis.school.dto.student;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import ru.itis.school.models.Student;
import ru.itis.school.models.Task;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewStudentDto {
    private UUID parentId;
    private UUID groupId;
    private String firstName;
    private Double rating;
    private List<Task> taskList;

    public static NewStudentDto from(Student student) {
        return NewStudentDto.builder()
                .firstName(student.getFirstName())
                .rating(student.getRating())
                .parentId(student.getParent().getId())
                .groupId(student.getGroup().getId())
                .taskList(student.getTaskList())
                .build();
    }

    public static List<NewStudentDto> from(List<Student> students) {
        if (CollectionUtils.isEmpty(students)) { return null; }

        return students
                .stream()
                .map(NewStudentDto::from)
                .collect(Collectors.toList());
    }
}
