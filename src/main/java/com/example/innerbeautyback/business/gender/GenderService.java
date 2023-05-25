package com.example.innerbeautyback.business.gender;

import com.example.innerbeautyback.domain.product.gender.Gender;
import com.example.innerbeautyback.domain.product.gender.GenderRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GenderService {
    @Resource
    private GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public Gender findById(Integer genderId) {
        return genderRepository.findById(genderId).get();
    }
}
