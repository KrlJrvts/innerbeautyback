package com.example.innerbeautyback.business.users;

import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.domain.image.ImageService;
import com.example.innerbeautyback.domain.user.User;
import com.example.innerbeautyback.domain.user.UserMapper;
import com.example.innerbeautyback.domain.user.UserService;
import com.example.innerbeautyback.util.ImageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ImageService imageService;

    @Transactional
    public void addUser(UserResponse userResponse) {
        userService.validateActiveUserBy(userResponse.getUserEmail());
        User user = createUser(userResponse);
        addImageIfPresent((Image) user.getImage());
        // TODO: addImageIfPresent
        userService.addUser(user);


    }

    public void addImageIfPresent(Image image) {
        if (ImageUtil.imageIsPresent(image)){
            imageService.addImage(image);
        }
        return;

    }

    private User createUser(UserResponse userResponse) {
        return userMapper.toRegisterUser(userResponse);



    }
}
