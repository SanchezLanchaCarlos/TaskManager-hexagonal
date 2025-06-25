package com.example.taskmanager.infrastructure.controller;

import com.example.taskmanager.domain.users.CreateUserUseCase;
import com.example.taskmanager.domain.users.RetrieveUserUseCase;
import com.example.taskmanager.infrastructure.mapper.UserDataMapper;
import com.example.taskmanager.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UsersApi;
import org.openapitools.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {

    private final CreateUserUseCase createUserUseCase;
    private final RetrieveUserUseCase retrieveUserUseCase;
    private final UserMapper userMapper;
    private final UserDataMapper userDataMapper;

    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(
                retrieveUserUseCase.getAllUsers()
                        .stream()
                        .map(userMapper::toResponse)
                        .toList()
        );
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(String id) {
        Optional<UserResponse> response = retrieveUserUseCase.getUserById(UUID.fromString(id)).map(userMapper::toResponse);

        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
