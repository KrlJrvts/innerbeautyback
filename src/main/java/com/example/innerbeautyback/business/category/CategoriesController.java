package com.example.innerbeautyback.business.category;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;


    @GetMapping("/store")
    @Operation(
            summary = "...",
            description = " Returns product info with ...")
    public List<CategoryRequest> getCategories() {
        List<CategoryRequest> category = categoriesService.getCategories();
        return category;
    }
}
