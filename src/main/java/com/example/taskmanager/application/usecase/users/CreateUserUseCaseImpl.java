package com.example.taskmanager.application.usecase.users;

import com.example.taskmanager.domain.model.User;
import com.example.taskmanager.domain.ports.in.users.CreateUserQuery;
import com.example.taskmanager.domain.ports.in.users.CreateUserUseCase;
import com.example.taskmanager.domain.ports.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    @Override
    public User create(CreateUserQuery query) {
        return userRepository.save(new User(
                null,
                query.username(),
                query.email(),
                query.password(),
                query.role(),
                null,
                LocalDateTime.now()
        ));
    }
}
