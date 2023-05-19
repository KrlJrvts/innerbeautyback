package com.example.innerbeautyback.business.products;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/store/products")
    @Operation(
            summary = "...",
            description = " Returns product info with ...")
    public List<ProductDto> getProducts() {
        List<ProductDto> product = productService.getProducts();
        return product;
    }
}