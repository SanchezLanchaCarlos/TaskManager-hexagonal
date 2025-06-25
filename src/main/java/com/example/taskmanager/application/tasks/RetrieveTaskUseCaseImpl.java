package com.example.taskmanager.application.tasks;

import com.example.taskmanager.domain.model.Task;
import com.example.taskmanager.domain.tasks.RetrieveTaskUseCase;
import com.example.taskmanager.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepository taskRepository;

    @Override
    public Optional<Task> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
