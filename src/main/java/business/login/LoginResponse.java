package business.login;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link domain.user.User} entity
 */
@Data
public class LoginResponse implements Serializable {
    private Integer userId;
    private String roleName;
}