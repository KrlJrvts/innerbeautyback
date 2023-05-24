package com.example.innerbeautyback.domain.product.bloodgroup;

import com.example.innerbeautyback.business.bloodgroup.BloodGroupResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BloodGroupMapper {

    @Mapping(source = "id",target = "bloodGroupTypeId")
    @Mapping(source = "type", target = "bloodGroupTypeName")
    BloodGroupResponse toDto(BloodGroup bloodGroup);

    List<BloodGroupResponse> toDtos(List<BloodGroup> bloodGroups);
}