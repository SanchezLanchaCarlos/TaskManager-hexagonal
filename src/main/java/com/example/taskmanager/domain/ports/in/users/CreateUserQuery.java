package com.example.taskmanager.domain.ports.in.users;

import com.example.taskmanager.domain.model.Role;

public record CreateUserQuery(String username, String email, String password, Role role) {
}
