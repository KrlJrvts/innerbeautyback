package com.example.innerbeautyback.business;

import lombok.Getter;


@Getter
public enum Status {

    ACTIVE("A"),
    DELETED("D"),
    CART("C"),
    FINISHED("F");

    private final String letter;

    Status(String letter) {
        this.letter = letter;
    }
}
