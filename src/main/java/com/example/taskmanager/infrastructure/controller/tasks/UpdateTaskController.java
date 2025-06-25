package com.example.taskmanager.infrastructure.controller.tasks;

import com.example.taskmanager.domain.tasks.UpdateTaskUseCase;
import com.example.taskmanager.infrastructure.mapper.TaskDataMapper;
import com.example.taskmanager.infrastructure.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.TasksApi;
import org.openapitools.model.TaskData;
import org.openapitools.model.TaskResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UpdateTaskController implements TasksApi {

    private final UpdateTaskUseCase updateTaskUseCase;
    private final TaskDataMapper taskDataMapper;
    private final TaskMapper taskMapper;

    @Override
    public ResponseEntity<TaskResponse> updateTask(String id, TaskData taskData) {
        Optional<TaskResponse> response = updateTaskUseCase.update(UUID.fromString(id), taskDataMapper.toCreateTaskQuery(taskData)).map(taskMapper::toResponse);

        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
