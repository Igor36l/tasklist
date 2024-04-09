package com.studyproject.tasklist.service;

import com.studyproject.tasklist.domain.task.Task;

import java.util.List;

public interface TaskService {
    Task getById(Long id);
    List<Task> getAllByUserId(Long id);
    Task create(Task task, Long UserId);
    Task update(Task task);
    void delete(Long id);
}
