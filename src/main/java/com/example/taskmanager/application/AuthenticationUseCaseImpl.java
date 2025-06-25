package com.example.taskmanager.application;

import com.example.taskmanager.domain.model.Role;
import com.example.taskmanager.domain.model.User;
import com.example.taskmanager.domain.auth.AuthRequestQuery;
import com.example.taskmanager.domain.auth.AuthResponseQuery;
import com.example.taskmanager.domain.auth.AuthenticationUseCase;
import com.example.taskmanager.domain.auth.RegisterRequestQuery;
import com.example.taskmanager.domain.JwtService;
import com.example.taskmanager.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponseQuery authenticate(AuthRequestQuery query) {
        User user = userRepository.findByEmail(query.email())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if(!passwordEncoder.matches(query.password(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        var jwt = jwtService.generateToken(user);
        return new AuthResponseQuery(jwt, user);
    }

    @Override
    public AuthResponseQuery register(RegisterRequestQuery query) {
        var user = new User();
        user.setEmail(query.email());
        user.setPassword(passwordEncoder.encode(query.password()));
        user.setUsername(query.username());
        try{
            user.setRole(Role.valueOf(query.role()));
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rol no válido");
        }
        user = userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return new AuthResponseQuery(jwt, user);
    }
}
