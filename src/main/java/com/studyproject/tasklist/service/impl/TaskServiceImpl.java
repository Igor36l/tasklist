package com.studyproject.tasklist.service.impl;

import com.studyproject.tasklist.domain.exception.ResourceNotFoundException;
import com.studyproject.tasklist.domain.task.Status;
import com.studyproject.tasklist.domain.task.Task;
import com.studyproject.tasklist.repository.TaskRepository;
import com.studyproject.tasklist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllByUserId(Long id) {
        return taskRepository.findAllByUserId(id);
    }

    @Override
    @Transactional
    public Task create(Task task, Long userId) {
        task.setStatus(Status.TODO);
        taskRepository.createTask(task);
        taskRepository.assignToUserId(task.getId(), userId);
        return task;
    }

    @Override
    @Transactional
    public Task update(Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        taskRepository.updateTask(task);
        return task;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.deleteTask(id);
    }
}
