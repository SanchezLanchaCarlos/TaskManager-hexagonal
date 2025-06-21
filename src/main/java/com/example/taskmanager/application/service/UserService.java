package com.example.taskmanager.application.service;

import com.example.taskmanager.application.usecase.users.CreateUserUseCaseImpl;
import com.example.taskmanager.application.usecase.users.RetrieveUserUseCaseImpl;
import com.example.taskmanager.domain.model.User;
import com.example.taskmanager.domain.ports.in.users.CreateUserQuery;
import com.example.taskmanager.domain.ports.in.users.CreateUserUseCase;
import com.example.taskmanager.domain.ports.in.users.RetrieveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements RetrieveUserUseCase, CreateUserUseCase {

    private final RetrieveUserUseCaseImpl retrieveUserUseCaseImpl;
    private final CreateUserUseCaseImpl createUserUseCaseImpl;

    @Override
    public Optional<User> getUserById(UUID id) {
        return retrieveUserUseCaseImpl.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return retrieveUserUseCaseImpl.getAllUsers();
    }

    @Override
    public User create(CreateUserQuery query) {
        return createUserUseCaseImpl.create(query);
    }
}
