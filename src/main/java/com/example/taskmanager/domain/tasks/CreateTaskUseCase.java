package com.example.taskmanager.domain.tasks;

import com.example.taskmanager.domain.model.Task;
import org.springframework.stereotype.Service;

@Service
public interface CreateTaskUseCase {
    Task create(CreateTaskQuery query);
}
