package com.example.innerbeautyback.domain.product;


import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.business.products.dtos.ProductsSearchRequest;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;
    public List<Product> getProducts(ProductsSearchRequest request) {
        Integer categoryId = request.getCategoryId();
        Integer countryId = request.getCountryId();
        Integer bloodgroupId = request.getBloodgroupId();
        return productRepository.findActiveAndInCartProductsBy(categoryId, countryId, bloodgroupId);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product findActiveProductBy(Integer productId) {
        return productRepository.getProductBy(productId, Status.ACTIVE.getLetter());
    }

    public Product getProductBy(Integer productId) {
        return productRepository.findById(productId).get();
    }
}
