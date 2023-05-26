package com.example.innerbeautyback.domain.user.userproduct;

import com.example.innerbeautyback.business.products.Dtos.ProductCartResponse;
import com.example.innerbeautyback.domain.product.Product;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductService {
    @Resource
    private UserProductRepository userProductRepository;

    public void addUserProduct(UserProduct userProduct) {
        userProductRepository.save(userProduct);
    }

    public UserProduct getProductBy(Integer productId) {
        return userProductRepository.getProductBy(productId);
    }

    public List<UserProduct> getAllProductsInCart(Integer buyerId) {
        List <UserProduct> userProducts = userProductRepository.findAllBy(buyerId);
        return userProducts;

    }
}
