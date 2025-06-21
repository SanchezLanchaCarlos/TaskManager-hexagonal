package com.example.taskmanager.domain.ports.in.auth;

public interface AuthenticationUseCase {

    AuthResponseQuery authenticate(AuthRequestQuery query);
    AuthResponseQuery register(RegisterRequestQuery query);
}
