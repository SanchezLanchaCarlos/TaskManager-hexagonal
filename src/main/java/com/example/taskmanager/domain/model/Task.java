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
public class Task {
    private UUID id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime dueDate;
}
