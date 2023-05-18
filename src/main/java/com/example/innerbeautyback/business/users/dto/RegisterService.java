package com.example.innerbeautyback.business.users.dto;

import com.example.innerbeautyback.business.users.UserResponse;
import com.example.innerbeautyback.business.users.dto.RoleService;
import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.domain.image.ImageService;
import com.example.innerbeautyback.domain.user.User;
import com.example.innerbeautyback.domain.user.UserMapper;
import com.example.innerbeautyback.domain.user.UserService;
import com.example.innerbeautyback.util.ImageUtil;
import jakarta.annotation.Resource;
import lombok.Setter;
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

    @Resource
    private RoleService roleService;

    @Transactional
    public void addUser(UserResponse userResponse) {
        userService.validateActiveUserBy(userResponse.getUserEmail());
        User user = createUser(userResponse);
        roleService.findRoleById("id");
        // TODO: 18.05.2023 otsi ülesse õige roll (user), kas id või name abil - roleService->roleRepository
        //  saate kätte role objekti
        //  panete userile külge (setter)

        addImageIfPresent((Image) user.getImage());
        userService.addUser(user);


    }

    public void addImageIfPresent(Image image) {
        if (ImageUtil.imageIsPresent(image)){
            imageService.addImage(image);
        }
    }

    private User createUser(UserResponse userResponse) {
        return userMapper.toRegisterUser(userResponse);



    }
}
