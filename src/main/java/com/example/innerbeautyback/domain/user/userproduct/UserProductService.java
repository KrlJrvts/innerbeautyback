package com.example.innerbeautyback.domain.user.userproduct;

import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.domain.product.Product;
import com.example.innerbeautyback.domain.product.ProductService;
import com.example.innerbeautyback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProductService {
    @Resource
    private UserProductRepository userProductRepository;

    @Resource
    private ProductService productService;



    public UserProduct getProductBy(Integer productId) {
        return userProductRepository.getProductBy(productId);
    }

    public List<UserProduct> getAllProductsInCart(Integer buyerId) {
        return userProductRepository.findAllBy(buyerId, Status.CART.getLetter());
    }

    public void buyProductsFromCart(Integer buyerId) {
        List<UserProduct> userProducts = userProductRepository.getProductsInCartBy(Status.CART.getLetter(), buyerId);
        List<Product> products = getAndSetFinishedProducts(userProducts);
        productService.addProducts(products);
    }


    public void removeProductFromCart(Integer buyerId, Integer productId) {
        UserProduct userProduct = userProductRepository.getProductBy(productId);
        boolean productInCart = userProduct.getBuyer() != null && userProduct.getBuyer().getId().equals(buyerId);
        ValidationService.validateProductInCart(productInCart);
        userProduct.getProduct().setStatus(Status.ACTIVE.getLetter());
        userProduct.setBuyer(null);
        userProduct.setTimestamp(null);
        userProductRepository.save(userProduct);
    }

    private static List<Product> getAndSetFinishedProducts(List<UserProduct> userProducts) {
        List <Product> products = new ArrayList<>();

        for (UserProduct userProduct : userProducts) {
            Product product = userProduct.getProduct();
            product.setStatus(Status.FINISHED.getLetter());
            products.add(product);
        }
        return products;
    }

    public void addUserProduct(UserProduct userProduct) {
        userProductRepository.save(userProduct);
    }
}
