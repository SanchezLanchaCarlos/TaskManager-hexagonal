package com.example.taskmanager.infrastructure.auth;

import com.example.taskmanager.application.service.AuthenticationService;
import com.example.taskmanager.domain.ports.in.auth.AuthRequestQuery;
import com.example.taskmanager.domain.ports.in.auth.RegisterRequestQuery;
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

    private final AuthenticationService authenticationService;
    private final AuthMapper authMapper;

    @Override
    public ResponseEntity<AuthResponse> register(RegisterData registerData) {
        RegisterRequestQuery query = authMapper.toRegisterRequestQuery(registerData);
        return ResponseEntity.ok(authMapper.toAuthResponse(authenticationService.register(query)));
    }

    @Override
    public ResponseEntity<AuthResponse> login(LoginData loginData) {
        AuthRequestQuery query = authMapper.toAuthRequestQuery(loginData);
        return ResponseEntity.ok(authMapper.toAuthResponse(authenticationService.authenticate(query)));
    }
}
