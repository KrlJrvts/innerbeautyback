package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.domain.product.ProductsService;
import com.example.innerbeautyback.domain.product.category.CategoryMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductsService productsService;


    public List<ProductDto> getProducts() {


        return null;
    }
}
