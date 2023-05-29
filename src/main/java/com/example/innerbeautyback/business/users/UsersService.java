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
    private ImageService imageService;

    @Resource
    private RoleService roleService;

    @Resource
    private ContactService contactService;

    @Resource
    private UserMapper userMapper;

    @Transactional
    public void addUser(UserRequest userRequest) {
        userService.validateActiveUserBy(userRequest.getUserEmail());

        User user = userMapper.toRegisterUser(userRequest);

        Contact contact = new Contact(userRequest.getContactFirstname(), userRequest.getContactLastname());
        contactService.addContact(contact);
        user.setContact(contact);

        Role role = roleService.findRoleUser();
        user.setRole(role);

        addImageIfPresent(user.getImage());
        userService.addUser(user);
    }

    @Transactional
    public void editUser(Integer userId, UserEditRequest userEditRequest) {
        User user = userService.getUserBy(userId);
        userMapper.toEditUser(userEditRequest, user);
        handleImageChange(user, userEditRequest.getUserImage());
        addImageIfPresent(user.getImage());
        userService.addUser(user);
    }

    public void addImageIfPresent(Image image) {
        if (ImageUtil.imageIsPresent(image)) {
            imageService.addImage(image);
        }
    }

    private void handleImageChange(User user, String imageDataFromUpdate) {
        Image currentImage = user.getImage();
        if (currentImageUpdateIsRequired(currentImage, imageDataFromUpdate)) {
            currentImage.setData(ImageUtil.base64ImageDataToByteArray(imageDataFromUpdate));
        }
        if (newImageIsRequired(imageDataFromUpdate, currentImage)) {
            Image newImage = new Image(ImageUtil.base64ImageDataToByteArray(imageDataFromUpdate));
            user.setImage(newImage);
        }

    }

    private static boolean currentImageUpdateIsRequired(Image currentImage, String imageDataFromUpdate) {
        return ImageUtil.imageIsPresent(currentImage)
                && !imageDataFromUpdate.equals(ImageUtil.byteArrayToBase64ImageData(currentImage.getData()));
    }

    private static boolean newImageIsRequired(String imageDataFromUpdate, Image currentImage) {
        return currentImage == null && !imageDataFromUpdate.isEmpty();
    }

}
