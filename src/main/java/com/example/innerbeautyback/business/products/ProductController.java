package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.business.category.CategoriesService;
import com.example.innerbeautyback.business.category.CategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Resource
    private ProductService productService;
    @Resource
    private CategoriesService categoriesService;


    @GetMapping("/store")
    @Operation(
            summary = "Returns all Product category names to storeView",
            description = " Returns product category names to storeView which shall be put under Product Category picture")
    public List<CategoryRequest> getCategories() {
        return categoriesService.getCategories();
    }


    @GetMapping("/store/products")
    @Operation(
            summary = "...",
            description = " Returns product info with ...")
    public List<ProductDto> getProducts() {
        List<ProductDto> product = productService.getProducts();
        return product;
    }
}