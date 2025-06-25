package com.example.taskmanager.infrastructure.controller.tasks;

import com.example.taskmanager.domain.model.Task;
import com.example.taskmanager.domain.tasks.CreateTaskUseCase;
import com.example.taskmanager.infrastructure.mapper.TaskDataMapper;
import com.example.taskmanager.infrastructure.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.TasksApi;
import org.openapitools.model.TaskData;
import org.openapitools.model.TaskResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateTaskController implements TasksApi {

    private final CreateTaskUseCase createTaskUseCase;
    private final TaskMapper taskMapper;
    private final TaskDataMapper taskDataMapper;

    @Override
    public ResponseEntity<TaskResponse> createTask(TaskData taskData) {
        Task task =  createTaskUseCase.create( taskDataMapper.toCreateTaskQuery(taskData));
        return  ResponseEntity.ok(taskMapper.toResponse(task));
    }
}
