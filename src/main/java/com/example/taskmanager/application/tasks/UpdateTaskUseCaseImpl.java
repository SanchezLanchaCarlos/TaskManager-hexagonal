package com.example.taskmanager.application.tasks;

import com.example.taskmanager.domain.model.Task;
import com.example.taskmanager.domain.tasks.CreateTaskQuery;
import com.example.taskmanager.domain.tasks.UpdateTaskUseCase;
import com.example.taskmanager.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepository taskRepository;

    @Override
    public Optional<Task> update(UUID id, CreateTaskQuery query) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            return Optional.empty();
        }

        task.setTitle(query.title());
        task.setDescription(query.description());
        task.setCompleted(query.completed());
        task.setDueDate(query.dueDate());

        return Optional.ofNullable(taskRepository.save(task));
    }
}
