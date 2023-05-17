package domain.user;

import business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import validation.ValidationService;

import java.util.Optional;

import static business.Status.ACTIVE;

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
