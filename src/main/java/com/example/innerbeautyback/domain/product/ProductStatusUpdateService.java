package com.example.innerbeautyback.domain.product;

import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.domain.user.userproduct.UserProduct;
import com.example.innerbeautyback.domain.user.userproduct.UserProductService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProductStatusUpdateService {
    @Resource
    private UserProductService userProductService;

    @Resource
    private ProductService productService;

    @Scheduled(fixedDelay = 60000) // Run every minute
    public void updateProductStatus() {
        LocalDateTime currentTime = LocalDateTime.now();
        List<UserProduct> cartProducts = userProductService.getCartProducts();

        for (UserProduct cartProduct : cartProducts) {
            LocalDateTime cartTimestamp = cartProduct.getTimestamp();
            Duration duration = Duration.between(cartTimestamp, currentTime);
            long minutesElapsed = duration.toMinutes();

            if (minutesElapsed >= 1) {
                // Change the status to "active"
                cartProduct.getProduct().setStatus("active");
                productService.addProduct(cartProduct.getProduct());

                // Remove the buyer from the UserProduct entity
                cartProduct.setBuyer(null);
                cartProduct.setTimestamp(null);
                userProductService.addUserProduct(cartProduct);
            }
        }
    }
}

