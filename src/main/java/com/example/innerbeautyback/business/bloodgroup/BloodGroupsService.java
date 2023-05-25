package com.example.innerbeautyback.business.bloodgroup;

import com.example.innerbeautyback.business.country.CountryResponse;
import com.example.innerbeautyback.domain.product.bloodgroup.BloodGroup;
import com.example.innerbeautyback.domain.product.bloodgroup.BloodGroupMapper;
import com.example.innerbeautyback.domain.product.bloodgroup.BloodGroupService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodGroupsService {

    @Resource
    private BloodGroupService bloodGroupService;

    @Resource
    private BloodGroupMapper bloodGroupMapper;

    public List<BloodGroupResponse> getBloodGroups() {

        List<BloodGroup> bloodGroups = bloodGroupService.getBloodGroups();

         return bloodGroupMapper.toDtos(bloodGroups);

    }
}
