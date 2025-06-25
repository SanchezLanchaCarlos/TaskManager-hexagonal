package com.example.taskmanager.domain.users;

import com.example.taskmanager.domain.model.User;

public interface CreateUserUseCase {
    User create(CreateUserQuery query);
}
