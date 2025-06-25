package com.example.taskmanager.infrastructure.mapper;

import com.example.taskmanager.domain.model.Role;
import com.example.taskmanager.domain.users.CreateUserQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.openapitools.model.UserData;

@Mapper(componentModel = "spring")
public interface UserDataMapper {

    @Mapping(target = "username")
    @Mapping(target = "email")
    @Mapping(target = "password")
    @Mapping(target = "role", qualifiedByName = "toRole")
    CreateUserQuery toCreateUserQuery(UserData user);

    @Named("toRole")
    default Role toRole(String role){
        return Role.valueOf(role.toUpperCase());
    }
}
