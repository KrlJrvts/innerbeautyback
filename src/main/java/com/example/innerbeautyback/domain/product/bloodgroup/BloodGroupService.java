package com.example.innerbeautyback.domain.product.bloodgroup;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodGroupService {
    @Resource
    private BloodGroupRepository bloodGroupRepository;

    public List<BloodGroup> getBloodGroups() {
        return bloodGroupRepository.findAll();
    }
}
