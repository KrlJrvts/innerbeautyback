package com.example.innerbeautyback.business.bloodgroup;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BloodGroupController {

    @Resource
    private BloodGroupsService bloodGroupsService;

    @GetMapping("/products/bloodgroups")
    @Operation(
            summary = "Returns all bloodGroups (from database bloodGroup table).",
            description = "Returns bloodGroupTypeId and bloodGroupTypeName.")
    public List<BloodGroupResponse> getBloodgroups() {
        return bloodGroupsService.getBloodGroups();
    }

}
