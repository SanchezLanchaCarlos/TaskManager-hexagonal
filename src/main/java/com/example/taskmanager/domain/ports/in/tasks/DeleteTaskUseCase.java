package com.example.taskmanager.domain.ports.in.tasks;

import java.util.UUID;

public interface DeleteTaskUseCase {

    boolean delete(UUID id);
}
