package com.example.innerbeautyback.business.country;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountriesController {

    @Resource
    private CountriesService countriesService;

    @GetMapping("/store/products")
    @Operation(
            summary = "Returns all countries (from database country table).",
            description = "Returns countryId and countryName.")
    public List<CountryResponse> getCountries() {
        return countriesService.getCountries();
    }

}
