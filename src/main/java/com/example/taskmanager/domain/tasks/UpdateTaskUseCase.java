package com.example.taskmanager.domain.tasks;

import com.example.taskmanager.domain.model.Task;

import java.util.Optional;
import java.util.UUID;

public interface UpdateTaskUseCase {
    Optional<Task> update(UUID id, CreateTaskQuery query);
}
