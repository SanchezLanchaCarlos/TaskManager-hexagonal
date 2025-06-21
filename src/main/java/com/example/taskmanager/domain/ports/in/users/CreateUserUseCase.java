package com.example.taskmanager.domain.ports.in.users;

import com.example.taskmanager.domain.model.User;

public interface CreateUserUseCase {
    User create(CreateUserQuery query);
}
