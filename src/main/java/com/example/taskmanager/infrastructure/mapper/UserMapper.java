package com.example.taskmanager.infrastructure.mapper;

import com.example.taskmanager.domain.model.User;
import com.example.taskmanager.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.UserResponse;

@Mapper(componentModel = "spring", uses = { DateMapper.class })
public interface UserMapper {

    @Mapping(target = "id")
    @Mapping(target = "username")
    @Mapping(target = "email")
    @Mapping(target = "password")
    @Mapping(target = "role")
    @Mapping(target = "avatar")
    @Mapping(target = "createdAt")
    UserEntity toEntity(User user);

    @Mapping(target = "id")
    @Mapping(target = "username")
    @Mapping(target = "email")
    @Mapping(target = "password")
    @Mapping(target = "role")
    @Mapping(target = "avatar")
    @Mapping(target = "createdAt")
    User toDomain(UserEntity userEntity);

    @Mapping(target = "id")
    @Mapping(target = "username")
    @Mapping(target = "email")
    @Mapping(target = "role")
    @Mapping(target = "avatar")
    @Mapping(target = "createdAt", qualifiedByName = "toOffsetDateTime")
    UserResponse toResponse(User user);
}
