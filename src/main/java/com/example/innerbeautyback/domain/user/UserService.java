package com.example.innerbeautyback.domain.user;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.innerbeautyback.validation.ValidationService;

import java.util.Optional;

import com.example.innerbeautyback.business.Status;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String email, String password) {
        Optional<User> userOptional = userRepository.findUserBy(email, password, Status.ACTIVE.getLetter());
        ValidationService.validateCorrectUserCredentials(userOptional);
        return userOptional.get();
    }

    public void validateActiveUserBy(String userEmail) {
        boolean userExists = userRepository.activeUserExistsBy(userEmail, Status.ACTIVE.getLetter());
        ValidationService.validateUserEmailIsAvailable(userExists);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserBy(Integer userId) {
        return userRepository.getUserBy(userId);
    }

}
