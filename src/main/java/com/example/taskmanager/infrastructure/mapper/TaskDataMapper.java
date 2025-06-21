package com.example.taskmanager.infrastructure.mapper;

import com.example.taskmanager.domain.ports.in.tasks.CreateTaskQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.TaskData;

@Mapper(componentModel = "spring", uses = { DateMapper.class })
public interface TaskDataMapper {

    @Mapping(target = "title")
    @Mapping(target = "description")
    @Mapping(target = "completed")
    @Mapping(target = "dueDate", qualifiedByName = "toLocalDateTime")
    CreateTaskQuery toCreateTaskQuery(TaskData taskData);
}
