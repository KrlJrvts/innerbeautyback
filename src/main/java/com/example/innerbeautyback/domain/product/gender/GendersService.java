package com.example.innerbeautyback.domain.product.gender;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GendersService {

    @Resource
    private GenderRepository genderRepository;
    public List<Gender> getGenders() {
        return genderRepository.findAll();
    }
}
