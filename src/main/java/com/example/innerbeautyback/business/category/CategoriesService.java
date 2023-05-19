package com.example.innerbeautyback.business.category;

import com.example.innerbeautyback.domain.product.category.Category;
import com.example.innerbeautyback.domain.product.category.CategoryMapper;
import com.example.innerbeautyback.domain.product.category.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryMapper categoryMapper;


    public List<CategoryRequest> getCategories() {
        List<Category> categories = categoryService.getCategories();
        return categoryMapper.toCategoryRequests(categories);


    }
}
