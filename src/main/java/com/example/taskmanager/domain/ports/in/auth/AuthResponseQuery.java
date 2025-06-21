package com.example.taskmanager.domain.ports.in.auth;

import com.example.taskmanager.domain.model.User;

public record AuthResponseQuery(String token, User user) {
}
