package com.example.innerbeautyback.domain.user.userproduct;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
}
