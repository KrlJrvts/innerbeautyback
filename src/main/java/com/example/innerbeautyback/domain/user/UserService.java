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

    public User findActiveUserBy(String email, String password) {
        Optional<User> userOptional = userRepository.findUserBy(email, password, ACTIVE.getLetter());
        ValidationService.validateCorrectUserCredentials(userOptional);
        User user = userOptional.get();
        return user;
    }
}
