package com.example.innerbeautyback.business.country;

import com.example.innerbeautyback.domain.country.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Country} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse implements Serializable {
    private Integer countryId;
    @Size(max = 255)
    @NotNull
    private String countryName;
}