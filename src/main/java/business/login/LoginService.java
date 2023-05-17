package business.login;


import domain.user.User;
import domain.user.UserMapper;
import domain.user.UserService;
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
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }
}
