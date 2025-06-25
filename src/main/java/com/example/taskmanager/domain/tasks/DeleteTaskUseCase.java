package com.example.taskmanager.domain.tasks;

import java.util.UUID;

public interface DeleteTaskUseCase {

    boolean delete(UUID id);
}
