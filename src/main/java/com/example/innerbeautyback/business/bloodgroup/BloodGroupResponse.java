package com.example.innerbeautyback.business.bloodgroup;

import com.example.innerbeautyback.domain.product.bloodgroup.BloodGroup;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link BloodGroup} entity
 */
@Data
public class BloodGroupResponse implements Serializable {
    private Integer bloodGroupTypeId;
    private String bloodGroupTypeName;
}