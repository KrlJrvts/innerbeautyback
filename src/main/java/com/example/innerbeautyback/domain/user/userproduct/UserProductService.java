package com.example.innerbeautyback.domain.user.userproduct;

import com.example.innerbeautyback.business.Status;
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
        return userProductRepository.findAllBy(buyerId, Status.CART.getLetter());
    }

    public List<UserProduct> getCartProducts() {
        return userProductRepository.findAllByStatus(Status.CART.getLetter());
    }

    public void deactivateProductFromCart(Integer buyerId) {
        List<UserProduct> userProducts = userProductRepository.getProductsInCartBy(Status.CART.getLetter(), buyerId);
        for (UserProduct userProduct : userProducts) {
            userProduct.getProduct().setStatus(Status.DELETED.getLetter());
            userProductRepository.save(userProduct);
        }
    }

    public void removeProductFromCart(Integer buyerId, Integer productId) {
        UserProduct userProduct = userProductRepository.getProductBy(productId);
        userProduct.getProduct().setStatus(Status.ACTIVE.getLetter());
        userProduct.setBuyer(null);
        userProduct.setTimestamp(null);
        userProductRepository.save(userProduct);
    }
}
