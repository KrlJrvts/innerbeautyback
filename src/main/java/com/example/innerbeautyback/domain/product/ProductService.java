package com.example.innerbeautyback.domain.product;


import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.business.products.Dtos.ProductsSearchRequest;
import com.example.innerbeautyback.domain.user.userproduct.UserProduct;
import com.example.innerbeautyback.domain.user.userproduct.UserProductRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;
    private final UserProductRepository userProductRepository;

    public ProductService(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    public List<Product> getProducts(ProductsSearchRequest request) {
        Integer categoryId = request.getCategoryId();
        Integer countryId = request.getCountryId();
        Integer bloodgroupId = request.getBloodgroupId();
        return productRepository.findProductsBy(categoryId, countryId, bloodgroupId, Status.ACTIVE.getLetter());
    }

    public void addProduct(Product product) {
        product.setStatus(Status.CART.getLetter());
        productRepository.save(product);
    }

}
