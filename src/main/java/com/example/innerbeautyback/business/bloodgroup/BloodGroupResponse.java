package com.example.innerbeautyback.business.bloodgroup;

import lombok.Data;
import java.io.Serializable;

@Data
public class BloodGroupResponse implements Serializable {
    private Integer bloodGroupTypeId;
    private String bloodGroupTypeName;
}