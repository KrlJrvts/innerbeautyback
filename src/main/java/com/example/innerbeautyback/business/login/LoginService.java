package com.example.innerbeautyback.business.login;

import com.example.innerbeautyback.domain.user.User;
import com.example.innerbeautyback.domain.user.UserMapper;
import com.example.innerbeautyback.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String email, String password) {
        User user = userService.findActiveUserBy(email, password);
        return userMapper.toLoginResponse(user);
    }
}
