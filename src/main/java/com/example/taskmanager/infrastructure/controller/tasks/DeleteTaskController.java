package com.example.taskmanager.infrastructure.controller.tasks;

import com.example.taskmanager.domain.tasks.DeleteTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.TasksApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DeleteTaskController implements TasksApi {

    private final DeleteTaskUseCase deleteTaskUseCase;

    @Override
    public ResponseEntity<Void> deleteTask(String id) {
        if(deleteTaskUseCase.delete(UUID.fromString(id)))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
