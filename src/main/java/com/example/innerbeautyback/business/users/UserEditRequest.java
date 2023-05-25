package com.example.innerbeautyback.business.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.innerbeautyback.domain.user.User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEditRequest implements Serializable {
    private String userPassword;
    private String userImage;
}