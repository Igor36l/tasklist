package com.studyproject.tasklist.web.mappers;

import com.studyproject.tasklist.domain.task.Task;
import com.studyproject.tasklist.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toList(List<Task> taskList);

    Task toEntity(TaskDto Dto);
}
