package com.example.innerbeautyback.validation;
import com.example.innerbeautyback.domain.user.User;
import com.example.innerbeautyback.infrastructure.exception.BusinessException;

import java.util.Optional;

public class ValidationService {

    public static void validateCorrectUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(Error.INCORRECT_CREDENTIALS.getMessage(), Error.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }
}