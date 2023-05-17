package com.example.innerbeautyback.business.users;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class UserResponse implements Serializable {
    private Integer userId;
    private String userEmail;
    private String userPassword;
    private byte[] imageData;
    private String contactFirstname;
    private String contactLastname;
    private String roleName;
}