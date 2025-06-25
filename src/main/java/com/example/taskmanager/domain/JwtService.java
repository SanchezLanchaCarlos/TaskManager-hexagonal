package com.example.taskmanager.domain;

import com.example.taskmanager.domain.model.User;

import java.security.Key;

public interface JwtService {

    String SECRET_KEY = "supersecreto1234567890supersecreto1234567890";
    long EXPIRATION = 1000L * 60 * 60 * 24;

    Key getSignInKey();
    String generateToken(User user);
    String extractEmail(String token);
    boolean isTokenValid(String token, User user);
    boolean isExpired(String token);
}
