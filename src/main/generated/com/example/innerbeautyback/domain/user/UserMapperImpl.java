package com.example.innerbeautyback.domain.user;

import com.example.innerbeautyback.business.login.LoginResponse;
import com.example.innerbeautyback.domain.user.role.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T13:00:41+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
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
