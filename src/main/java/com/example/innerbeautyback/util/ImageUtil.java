package com.example.innerbeautyback.util;

import com.example.innerbeautyback.domain.image.Image;

import java.nio.charset.StandardCharsets;

public class ImageUtil {

    public static byte[] base64ImageDataToByteArray(String imageData) {
        return imageData.getBytes(StandardCharsets.UTF_8);
    }

    public static String byteArrayToBase64ImageData(byte[] data) {
        return new String(data, StandardCharsets.UTF_8);
    }

    public static boolean imageIsPresent(Image image) {
        return image != null;
    }
}