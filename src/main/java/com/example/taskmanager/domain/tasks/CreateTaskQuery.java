package com.example.taskmanager.domain.tasks;

import java.time.LocalDateTime;

public record CreateTaskQuery(String title, String description, boolean completed, LocalDateTime dueDate) {
}
