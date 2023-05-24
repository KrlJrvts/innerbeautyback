package com.example.innerbeautyback.domain.country;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Resource
    private CountryRepository countryRepository;

    public List<Country> getCountries() {

        return countryRepository.findAll();

       }
}
