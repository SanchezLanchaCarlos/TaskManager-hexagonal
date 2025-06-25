package com.example.taskmanager.infrastructure.controller.tasks;

import com.example.taskmanager.domain.tasks.RetrieveTaskUseCase;
import com.example.taskmanager.infrastructure.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.TasksApi;
import org.openapitools.model.TaskResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RetrieveTaskController implements TasksApi {

    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final TaskMapper taskMapper;

    @Override
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<TaskResponse> response = retrieveTaskUseCase.getAllTasks()
                .stream()
                .map(taskMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<TaskResponse> getTaskById(String id) {
        Optional<TaskResponse> response = retrieveTaskUseCase.getTaskById(UUID.fromString(id)).map(taskMapper::toResponse);

        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
