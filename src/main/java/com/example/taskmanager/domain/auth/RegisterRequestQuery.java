package com.example.taskmanager.domain.auth;

public record RegisterRequestQuery(String email, String password, String username, String role) {
}
