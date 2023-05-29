package com.example.innerbeautyback.domain.product.gender;

import com.example.innerbeautyback.business.gender.GenderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenderMapper {

    @Mapping(source = "id", target = "genderId")
    @Mapping(source = "name", target = "genderName")
    GenderResponse toDto(Gender gender);
    List<GenderResponse> toDtos(List<Gender> genders);
}