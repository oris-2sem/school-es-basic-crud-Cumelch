package ru.itis.school.dto.timetable;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import ru.itis.school.models.Timetable;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewTimetableDto {
    private UUID teacherId;
    private UUID groupId;
    private Date dateTime;
    private String room;

    public static NewTimetableDto from(Timetable timetable) {
        return NewTimetableDto.builder()
                .dateTime(timetable.getDateTime())
                .room(timetable.getRoom())
                .teacherId(timetable.getTeacher().getId())
                .groupId(timetable.getGroup().getId())
                .build();
    }

    public static List<NewTimetableDto> from(List<Timetable> timetables) {
        if (CollectionUtils.isEmpty(timetables)) { return null; }

        return timetables
                .stream()
                .map(NewTimetableDto::from)
                .collect(Collectors.toList());
    }
}
