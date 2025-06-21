package com.example.taskmanager.domain.ports.out;

import com.example.taskmanager.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    List<User> findAll();
    Optional<User> update(User user);
    void delete(UUID id);
}
