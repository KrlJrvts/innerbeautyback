package com.example.innerbeautyback.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;
    public Role findRoleUser() {
        return roleRepository.findById(1).get();
    }

}
