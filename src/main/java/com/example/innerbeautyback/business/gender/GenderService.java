package com.example.innerbeautyback.business.gender;

import com.example.innerbeautyback.domain.product.gender.Gender;
import com.example.innerbeautyback.domain.product.gender.GenderMapper;
import com.example.innerbeautyback.domain.product.gender.GenderRepository;
import com.example.innerbeautyback.domain.product.gender.GendersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    @Resource
    private GendersService gendersService;
    @Resource
    private GenderMapper genderMapper;
    @Resource
    private GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {

        this.genderRepository = genderRepository;
    }

    public Gender findById(Integer genderId) {

        return genderRepository.findById(genderId).get();
    }

    public List<GenderResponse> getGenders() {

        List<Gender> genders = gendersService.getGenders();
        return genderMapper.toDtos(genders);
    }
}
