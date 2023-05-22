package com.example.innerbeautyback.business.country;

import com.example.innerbeautyback.domain.country.Country;
import com.example.innerbeautyback.domain.country.CountryMapper;
import com.example.innerbeautyback.domain.country.CountryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesService {

    @Resource
    private CountryService countryService;

    @Resource
    private CountryMapper countryMapper;

    public List<CountryResponse> getCountries() {
        List<Country> countries = countryService.getCountries();

        return countryMapper.toDtos(countries);
    }
}
