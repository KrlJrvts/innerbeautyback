package com.example.innerbeautyback.domain.product;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Resource
    private ProductRepository productRepository;
}
