package com.example.taskmanager.domain.ports.in.auth;

public record RegisterRequestQuery(String email, String password, String username, String role) {
}
