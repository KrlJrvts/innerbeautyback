package com.example.innerbeautyback.domain.user;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.innerbeautyback.validation.ValidationService;

import java.util.Optional;

import static com.example.innerbeautyback.business.Status.ACTIVE;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> userOptional = userRepository.findUserBy(username, password, ACTIVE.getLetter());
        ValidationService.validateCorrectUserCredentials(userOptional);
        User user = userOptional.get();
        return user;
    }
}
