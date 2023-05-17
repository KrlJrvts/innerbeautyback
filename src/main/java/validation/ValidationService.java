package validation;
import  domain.user.User;
import infrastructure.exception.BusinessException;

import java.util.Optional;

import static validation.Error.INCORRECT_CREDENTIALS;

public class ValidationService {

    public static void validateCorrectUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
    }
}
