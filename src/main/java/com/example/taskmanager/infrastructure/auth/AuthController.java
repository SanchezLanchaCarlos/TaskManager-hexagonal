package com.example.taskmanager.infrastructure.auth;

import com.example.taskmanager.domain.auth.AuthRequestQuery;
import com.example.taskmanager.domain.auth.AuthenticationUseCase;
import com.example.taskmanager.domain.auth.RegisterRequestQuery;
import com.example.taskmanager.infrastructure.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.AuthApi;
import org.openapitools.model.AuthResponse;
import org.openapitools.model.LoginData;
import org.openapitools.model.RegisterData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthenticationUseCase authenticationUseCase;
    private final AuthMapper authMapper;

    @Override
    public ResponseEntity<AuthResponse> register(RegisterData registerData) {
        RegisterRequestQuery query = authMapper.toRegisterRequestQuery(registerData);
        return ResponseEntity.ok(authMapper.toAuthResponse(authenticationUseCase.register(query)));
    }

    @Override
    public ResponseEntity<AuthResponse> login(LoginData loginData) {
        AuthRequestQuery query = authMapper.toAuthRequestQuery(loginData);
        return ResponseEntity.ok(authMapper.toAuthResponse(authenticationUseCase.authenticate(query)));
    }
}
