package com.example.innerbeautyback.domain.user;

import com.example.innerbeautyback.business.login.LoginResponse;
import com.example.innerbeautyback.business.users.UserResponse;
import org.mapstruct.*;
import com.example.innerbeautyback.business.Status;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);



    @Mapping(source = "userEmail", target = "email")
    @Mapping(source = "userPassword", target = "password")
    @Mapping(source = "roleName", target = "role.name")
    // @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    @Mapping(source = "contactFirstname", target = "contact.firstname")
    @Mapping(source = "contactLastname", target = "contact.lastname")
    @Mapping(ignore = true, target = "image")
    User toRegisterUser(UserResponse userResponse);
}