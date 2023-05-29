package com.example.innerbeautyback.business.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse implements Serializable {
    private Integer countryId;
    private String countryName;
}