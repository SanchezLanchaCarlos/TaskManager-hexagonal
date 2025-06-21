package com.example.taskmanager.application.usecase.tasks;

import com.example.taskmanager.domain.model.Task;
import com.example.taskmanager.domain.ports.in.tasks.CreateTaskQuery;
import com.example.taskmanager.domain.ports.in.tasks.CreateTaskUseCase;
import com.example.taskmanager.domain.ports.out.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepository taskRepository;

    @Override
    public Task create(CreateTaskQuery query) {
        return taskRepository.save(new Task(
                null,
                query.title(),
                query.description(),
                query.completed(),
                query.dueDate()));
    }
}
