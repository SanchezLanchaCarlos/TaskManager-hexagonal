package com.example.taskmanager.infrastructure.repository;

import com.example.taskmanager.domain.model.User;
import com.example.taskmanager.domain.repository.UserRepository;
import com.example.taskmanager.infrastructure.entity.UserEntity;
import com.example.taskmanager.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SupabaseUserRepository implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity entity = jpaUserRepository.save(userMapper.toEntity(user));
        return userMapper.toDomain(entity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaUserRepository.findById(id)
                .map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email)
                .map(userMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll()
                .stream()
                .map(userMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> update(User user) {
        return Optional.of(jpaUserRepository.save(userMapper.toEntity(user)))
                .map(userMapper::toDomain);
    }

    @Override
    public void delete(UUID id) {
        jpaUserRepository.deleteById(id);
    }
}
