package com.example.taskmanager.application.service;

import com.example.taskmanager.application.usecase.auth.AuthenticationUseCaseImpl;
import com.example.taskmanager.domain.ports.in.auth.AuthRequestQuery;
import com.example.taskmanager.domain.ports.in.auth.AuthResponseQuery;
import com.example.taskmanager.domain.ports.in.auth.AuthenticationUseCase;
import com.example.taskmanager.domain.ports.in.auth.RegisterRequestQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationUseCase {

    private final AuthenticationUseCaseImpl authenticationUseCaseImpl;

    @Override
    public AuthResponseQuery authenticate(AuthRequestQuery query) {
        return authenticationUseCaseImpl.authenticate(query);
    }

    @Override
    public AuthResponseQuery register(RegisterRequestQuery query) {
        return authenticationUseCaseImpl.register(query);
    }
}
