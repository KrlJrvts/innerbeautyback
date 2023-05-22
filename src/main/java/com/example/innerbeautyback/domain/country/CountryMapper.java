package com.example.innerbeautyback.domain.country;

import com.example.innerbeautyback.business.country.CountryResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {

    @Mapping(source = "id", target = "countryId")
    @Mapping(source = "name", target = "countryName")
    CountryResponse toDto(Country country);

    List<CountryResponse> toDtos(List<Country> countries);
}