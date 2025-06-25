package com.example.taskmanager.application.tasks;

import com.example.taskmanager.domain.tasks.DeleteTaskUseCase;
import com.example.taskmanager.domain.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public boolean delete(UUID id) {
        if(taskRepository.findById(id).isPresent()) {
            taskRepository.delete(id);
            return true;
        }

        return false;
    }
}
