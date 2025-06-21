package com.example.taskmanager.domain.ports.in.auth;

public record AuthRequestQuery(String email, String password) {
}
