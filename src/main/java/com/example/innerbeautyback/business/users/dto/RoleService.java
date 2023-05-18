package com.example.innerbeautyback.business.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.innerbeautyback.domain.user.role.Role}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleService implements Serializable {
    private Integer roleId;



    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
        return
    }

    public void findRoleById(String id) {
    }
}