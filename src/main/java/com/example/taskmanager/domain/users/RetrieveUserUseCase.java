package com.example.taskmanager.domain.users;

import com.example.taskmanager.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetrieveUserUseCase {
    Optional<User> getUserById(UUID id);
    List<User> getAllUsers();
}
