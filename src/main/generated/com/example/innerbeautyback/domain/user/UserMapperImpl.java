package com.example.innerbeautyback.domain.user;

import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.business.login.LoginResponse;
import com.example.innerbeautyback.business.users.UserRequest;
import com.example.innerbeautyback.business.users.UserRequestExtended;
import com.example.innerbeautyback.domain.user.role.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-25T11:25:57+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public LoginResponse toLoginResponse(User user) {
        if ( user == null ) {
            return null;
        }

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setUserId( user.getId() );
        loginResponse.setRoleName( userRoleName( user ) );

        return loginResponse;
    }

    @Override
    public User toRegisterUser(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userRequest.getUserEmail() );
        user.setPassword( userRequest.getUserPassword() );
        user.setImage( UserMapper.imageDataToImage( userRequest.getUserImage() ) );

        user.setStatus( Status.ACTIVE.getLetter() );

        return user;
    }

    @Override
    public User toEditUser(UserRequestExtended userRequestExtended, User user) {
        if ( userRequestExtended == null ) {
            return user;
        }

        user.setId( userRequestExtended.getUserId() );
        user.setPassword( userRequestExtended.getUserPassword() );

        return user;
    }

    private String userRoleName(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
