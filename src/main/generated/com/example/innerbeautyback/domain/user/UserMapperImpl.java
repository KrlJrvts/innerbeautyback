package com.example.innerbeautyback.domain.user;

import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.business.login.LoginResponse;
import com.example.innerbeautyback.business.users.UserResponse;
import com.example.innerbeautyback.domain.user.contact.Contact;
import com.example.innerbeautyback.domain.user.role.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T13:13:15+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
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
    public User toRegisterUser(UserResponse userResponse) {
        if ( userResponse == null ) {
            return null;
        }

        User user = new User();

        user.setRole( userResponseToRole( userResponse ) );
        user.setContact( userResponseToContact( userResponse ) );
        user.setEmail( userResponse.getUserEmail() );
        user.setPassword( userResponse.getUserPassword() );
        user.setImage( UserMapper.imageDataToImage( userResponse.getUserImage() ) );

        user.setStatus( Status.ACTIVE.getLetter() );

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

    protected Role userResponseToRole(UserResponse userResponse) {
        if ( userResponse == null ) {
            return null;
        }

        Role role = new Role();

        role.setName( userResponse.getRoleName() );

        return role;
    }

    protected Contact userResponseToContact(UserResponse userResponse) {
        if ( userResponse == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setFirstname( userResponse.getContactFirstname() );
        contact.setLastname( userResponse.getContactLastname() );

        return contact;
    }
}
