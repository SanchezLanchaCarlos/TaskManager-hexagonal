package com.example.taskmanager.infrastructure.repository;

import com.example.taskmanager.domain.model.Task;
import com.example.taskmanager.domain.repository.TaskRepository;
import com.example.taskmanager.infrastructure.entity.TaskEntity;
import com.example.taskmanager.infrastructure.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SupabaseTaskRepository implements TaskRepository {

    private final JpaTaskRepository jpaTaskRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = taskMapper.toEntity(task);
        return taskMapper.toDomain(jpaTaskRepository.save(taskEntity));
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return jpaTaskRepository.findById(id).map(taskMapper::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(taskMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Task> update(Task task) {
        return Optional.of(jpaTaskRepository.save(taskMapper.toEntity(task)))
                .map(taskMapper::toDomain);
    }

    @Override
    public void delete(UUID id) {
        jpaTaskRepository.deleteById(id);
    }
}
