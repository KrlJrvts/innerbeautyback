package com.example.innerbeautyback.domain.product;


import com.example.innerbeautyback.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductRepository productRepository;

    public List<Product> getProductsBy(Integer categoryId) {
        return productRepository.findProductsBy(categoryId,Status.ACTIVE.getLetter());
    }
}
