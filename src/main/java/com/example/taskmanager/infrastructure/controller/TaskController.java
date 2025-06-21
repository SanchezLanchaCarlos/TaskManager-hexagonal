package com.example.taskmanager.infrastructure.controller;

import com.example.taskmanager.application.service.TaskService;
import com.example.taskmanager.domain.model.Task;
import com.example.taskmanager.infrastructure.mapper.TaskDataMapper;
import com.example.taskmanager.infrastructure.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.TasksApi;
import org.openapitools.model.TaskData;
import org.openapitools.model.TaskResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TaskController implements TasksApi {

    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final TaskDataMapper taskDataMapper;

    @Override
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<TaskResponse> response = taskService.getAllTasks()
                .stream()
                .map(taskMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<TaskResponse> getTaskById(String id) {
        Optional<TaskResponse> response = taskService.getTaskById(UUID.fromString(id)).map(taskMapper::toResponse);

        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TaskResponse> createTask(TaskData taskData) {
        Task task =  taskService.create( taskDataMapper.toCreateTaskQuery(taskData));
        return  ResponseEntity.ok(taskMapper.toResponse(task));
    }

    @Override
    public ResponseEntity<TaskResponse> updateTask(String id, TaskData taskData) {
        Optional<TaskResponse> response = taskService.update(UUID.fromString(id), taskDataMapper.toCreateTaskQuery(taskData)).map(taskMapper::toResponse);

        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteTask(String id) {
        if(taskService.delete(UUID.fromString(id)))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
