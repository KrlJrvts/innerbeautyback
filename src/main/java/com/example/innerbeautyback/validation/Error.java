package com.example.innerbeautyback.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Wrong email or password", 111),
    USER_UNAVAILABLE("User with this e-mail already exist", 112),
    PRODUCT_IN_FAVORITES("Product is already in favorites", 211),
    PRODUCT_IN_CART("Product is already in cart", 212);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
