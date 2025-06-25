package com.example.taskmanager.domain.auth;

public interface AuthenticationUseCase {

    AuthResponseQuery authenticate(AuthRequestQuery query);
    AuthResponseQuery register(RegisterRequestQuery query);
}
