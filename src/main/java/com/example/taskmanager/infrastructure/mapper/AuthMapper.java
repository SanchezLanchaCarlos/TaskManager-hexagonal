package com.example.taskmanager.infrastructure.mapper;

import com.example.taskmanager.domain.auth.AuthRequestQuery;
import com.example.taskmanager.domain.auth.AuthResponseQuery;
import com.example.taskmanager.domain.auth.RegisterRequestQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.AuthResponse;
import org.openapitools.model.LoginData;
import org.openapitools.model.RegisterData;

@Mapper(componentModel = "spring", uses =  {UserMapper.class})
public interface AuthMapper {
    @Mapping(target = "email")
    @Mapping(target = "password")
    AuthRequestQuery toAuthRequestQuery(LoginData loginData);

    @Mapping(target = "email")
    @Mapping(target = "password")
    @Mapping(target = "username")
    @Mapping(target = "role")
    RegisterRequestQuery toRegisterRequestQuery(RegisterData registerData);

    @Mapping(target = "token")
    @Mapping(target = "user", qualifiedByName = "toResponse")
    AuthResponse toAuthResponse(AuthResponseQuery authResponseQuery);
}
