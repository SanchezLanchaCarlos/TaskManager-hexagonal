package com.example.taskmanager.infrastructure.mapper;

import com.example.taskmanager.domain.model.Task;
import com.example.taskmanager.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.TaskResponse;

@Mapper(componentModel = "spring", uses = { DateMapper.class })
public interface TaskMapper {

    @Mapping(target = "id")
    @Mapping(target = "title")
    @Mapping(target = "description")
    @Mapping(target = "completed")
    @Mapping(target = "dueDate")
    Task toDomain(final TaskEntity taskEntity);

    @Mapping(target = "id")
    @Mapping(target = "title")
    @Mapping(target = "description")
    @Mapping(target = "completed")
    @Mapping(target = "dueDate")
    TaskEntity toEntity(final Task domainTask);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "completed", target = "completed")
    @Mapping(source = "dueDate", target = "dueDate", qualifiedByName = "toOffsetDateTime")
    TaskResponse toResponse(Task task);
}
