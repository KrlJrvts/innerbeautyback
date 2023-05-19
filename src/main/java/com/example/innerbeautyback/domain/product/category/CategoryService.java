package com.example.innerbeautyback.domain.product.category;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryRepository categoryRepository;
    public List<Category> getCategories() {

        return categoryRepository.findAll();
    }
}
