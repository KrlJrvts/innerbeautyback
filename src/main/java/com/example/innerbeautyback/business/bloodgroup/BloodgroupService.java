package com.example.innerbeautyback.business.bloodgroup;

import com.example.innerbeautyback.domain.product.bloodgroup.BloodGroup;
import com.example.innerbeautyback.domain.product.bloodgroup.BloodGroupRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class BloodgroupService {

    @Resource
    private BloodGroupRepository bloodgroupRepository;

    public BloodGroup findById(Integer bloodGroupId) {

        return bloodgroupRepository.findById(bloodGroupId).get();
    }

}
