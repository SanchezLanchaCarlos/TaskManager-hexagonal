package com.example.taskmanager.domain.tasks;

import com.example.taskmanager.domain.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetrieveTaskUseCase {
    Optional<Task> getTaskById(UUID id);
    List<Task> getAllTasks();
}
