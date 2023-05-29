package com.example.innerbeautyback.business.gender;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenderController {

    @Resource
    private GenderService genderService;

    @GetMapping("/products/genders")
    @Operation(
            summary = "Returns all genders (from database gender table).",
            description = "Returns genderId and genderName.")
    public List<GenderResponse> getGenders() {

        return genderService.getGenders();
    }
}
