package com.studyproject.tasklist.web.controller;

import com.studyproject.tasklist.domain.task.Task;
import com.studyproject.tasklist.domain.user.User;
import com.studyproject.tasklist.service.TaskService;
import com.studyproject.tasklist.service.UserService;
import com.studyproject.tasklist.web.dto.task.TaskDto;
import com.studyproject.tasklist.web.dto.user.UserDto;
import com.studyproject.tasklist.web.dto.validation.OnCreate;
import com.studyproject.tasklist.web.dto.validation.OnUpdate;
import com.studyproject.tasklist.web.mappers.TaskMapper;
import com.studyproject.tasklist.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Validated
public class UserController {

    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User userUpdated = userService.update(user);
        return userMapper.toDto(userUpdated);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
       userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id) {
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toList(tasks);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto crateTask(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto dto) {
      Task task = taskMapper.toEntity(dto);
      Task taskCreated = taskService.create(task, id);
      return taskMapper.toDto(taskCreated);
    }


}
