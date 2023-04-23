package ru.itis.school.dto.parent;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import ru.itis.school.models.Parent;
import ru.itis.school.models.Student;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewParentDto {
    private String name;
    private List<Student> children;

    public static NewParentDto from(Parent parent) {
        return NewParentDto.builder()
                .name(parent.getName())
                .children(parent.getChildren())
                .build();
    }

    public static List<NewParentDto> from(List<Parent> parents) {
        if (CollectionUtils.isEmpty(parents)) { return null; }

        return parents
                .stream()
                .map(NewParentDto::from)
                .collect(Collectors.toList());
    }
}
