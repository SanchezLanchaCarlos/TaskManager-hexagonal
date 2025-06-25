package com.example.taskmanager.infrastructure.controller;

import com.example.taskmanager.domain.users.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UsersApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateUserController implements UsersApi {

    private final CreateUserUseCase createUserUseCase;


}
