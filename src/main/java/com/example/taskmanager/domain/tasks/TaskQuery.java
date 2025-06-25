package com.example.taskmanager.domain.tasks;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskQuery(UUID id, String title, String description, boolean completed, LocalDateTime dueDate) {
}
