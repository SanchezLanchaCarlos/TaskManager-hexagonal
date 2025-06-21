package com.example.taskmanager.infrastructure.repository;

import com.example.taskmanager.infrastructure.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findById(UUID id);
    void deleteById(UUID id);
}
