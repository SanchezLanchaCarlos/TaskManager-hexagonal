package com.example.taskmanager.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private String avatar;
    private LocalDateTime createdAt;
}
