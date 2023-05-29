package com.example.innerbeautyback.business.login;

import lombok.Data;
import java.io.Serializable;

@Data
public class LoginResponse implements Serializable {
    private Integer userId;
    private String roleName;
}