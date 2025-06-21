package com.example.taskmanager.application.service;

import com.example.taskmanager.application.usecase.tasks.CreateTaskUseCaseImpl;
import com.example.taskmanager.application.usecase.tasks.RetrieveTaskUseCaseImpl;
import com.example.taskmanager.domain.model.Task;
import com.example.taskmanager.domain.ports.in.tasks.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService implements RetrieveTaskUseCase, CreateTaskUseCase, DeleteTaskUseCase, UpdateTaskUseCase {

    private final RetrieveTaskUseCaseImpl retrieveTaskUseCaseImpl;
    private final CreateTaskUseCaseImpl createTaskUseCaseImpl;
    private final DeleteTaskUseCase deleteTaskUseCaseImpl;
    private final UpdateTaskUseCase updateTaskUseCaseImpl;

    @Override
    public Optional<Task> getTaskById(UUID id) {
        return retrieveTaskUseCaseImpl.getTaskById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCaseImpl.getAllTasks();
    }

    @Override
    public Task create(CreateTaskQuery query) {
        return createTaskUseCaseImpl.create(query);
    }

    @Override
    public boolean delete(UUID id) {
        return deleteTaskUseCaseImpl.delete(id);
    }

    @Override
    public Optional<Task> update(UUID id, CreateTaskQuery query) {
        return updateTaskUseCaseImpl.update(id, query);
    }
}
