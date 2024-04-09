package com.studyproject.tasklist.repository;

import com.studyproject.tasklist.domain.task.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional<Task> findById(Long id);
    List<Task> findAllByUserId(Long userId);
    void assignToUserId(Long TaskId, Long userId);
    void updateTask(Task task);
    void createTask(Task task);
    void deleteTask(Long id);
}
