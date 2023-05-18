package com.example.innerbeautyback.business.users;

import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.domain.image.ImageService;
import com.example.innerbeautyback.domain.user.User;
import com.example.innerbeautyback.domain.user.UserMapper;
import com.example.innerbeautyback.domain.user.UserService;
import com.example.innerbeautyback.domain.user.contact.Contact;
import com.example.innerbeautyback.domain.user.contact.ContactService;
import com.example.innerbeautyback.domain.user.role.Role;
import com.example.innerbeautyback.domain.user.role.RoleService;
import com.example.innerbeautyback.util.ImageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ImageService imageService;

    @Resource
    private RoleService roleService;

    @Resource
    private ContactService contactService;

    @Transactional
    public void addUser(UserRequest userRequest) {
        userService.validateActiveUserBy(userRequest.getUserEmail());

        User user = userMapper.toRegisterUser(userRequest);

        // Create and associate (SAVE) a Contact entity
        Contact contact = new Contact(userRequest.getContactFirstname(), userRequest.getContactLastname());
        contactService.addContact(contact);
        user.setContact(contact);

        // Find associated role entity
        Role role = roleService.findRoleUser();
        user.setRole(role);

        addImageIfPresent(user.getImage());
        userService.addUser(user);
    }

    public void addImageIfPresent(Image image) {
        if (ImageUtil.imageIsPresent(image)) {
            imageService.addImage(image);
        }
    }
}
