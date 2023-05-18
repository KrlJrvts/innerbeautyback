package com.example.innerbeautyback.domain.user;

import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.business.login.LoginResponse;
import com.example.innerbeautyback.business.users.UserResponse;
import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.util.ImageUtil;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);



    @Mapping(source = "userEmail", target = "email")
    @Mapping(source = "userPassword", target = "password")
    @Mapping(source = "roleName", target = "role.name")
    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    @Mapping(source = "contactFirstname", target = "contact.firstname")
    @Mapping(source = "contactLastname", target = "contact.lastname")
    @Mapping(source = "userImage", target = "image.data", qualifiedByName = "imageToImageData")
    User toRegisterUser(UserResponse userResponse);


    @Named("imageDataToImage")
    static Image imageDataToImage(String imageData) {
        if (imageData.isEmpty()) {
            return null;
        }
        return new Image(ImageUtil.base64ImageDataToByteArray(imageData));
    }

    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }
}