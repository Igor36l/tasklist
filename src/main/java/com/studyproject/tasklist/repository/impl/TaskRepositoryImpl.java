package com.studyproject.tasklist.repository.impl;

import com.studyproject.tasklist.domain.task.Task;
import com.studyproject.tasklist.repository.DataSourceConfig;
import com.studyproject.tasklist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final DataSourceConfig dataSourceConfig;

    private final  String FIND_DY_ID = "";


    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllByUserId(Long userId) {
        return List.of();
    }

    @Override
    public void assignToUserId(Long TaskId, Long userId) {

    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void createTask(Task task) {

    }

    @Override
    public void deleteTask(Long id) {

    }
}
