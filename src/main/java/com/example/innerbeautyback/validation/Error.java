package com.example.innerbeautyback.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Wrong email or password", 111),
//    NO_LOCATION_FOUND("Ei leitud ühtegi pangaautomaati", 222),
//    LOCATION_UNAVAILABLE("Sellise nimega pangaautomaadi asukoht on juba süsteemis olemas", 333);
    USER_UNAVAILABLE("User with this e-mail already exist", 112);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
