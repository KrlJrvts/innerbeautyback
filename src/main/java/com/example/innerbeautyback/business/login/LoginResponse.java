package com.example.innerbeautyback.business.login;

import com.example.innerbeautyback.domain.user.User;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class LoginResponse implements Serializable {
    private Integer userId;
    private String roleName;
}