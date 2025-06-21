package com.example.taskmanager.domain.ports.in.tasks;

import com.example.taskmanager.domain.model.Task;

public interface CreateTaskUseCase {
    Task create(CreateTaskQuery query);
}
