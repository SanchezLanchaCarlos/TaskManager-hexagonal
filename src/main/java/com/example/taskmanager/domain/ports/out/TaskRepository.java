package com.example.taskmanager.domain.ports.out;

import com.example.taskmanager.domain.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(UUID id);
    List<Task> findAll();
    Optional<Task> update(Task task);
    void delete(UUID id);
}
