package com.example.innerbeautyback.domain.product;


import com.example.innerbeautyback.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductRepository productRepository;

    public List<Product> getProductsBy(Integer categoryId, Integer countryId, Integer bloodgroupId) {
        return productRepository.findProductsBy(categoryId,countryId,bloodgroupId,Status.ACTIVE.getLetter());
    }
}
