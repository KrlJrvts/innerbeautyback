package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.domain.product.Product;
import com.example.innerbeautyback.domain.product.ProductMapper;
import com.example.innerbeautyback.domain.product.ProductService;
import com.example.innerbeautyback.domain.user.favorite.FavoriteService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private FavoriteService favoriteService;

    @Resource
    private ProductMapper productMapper;

//    public List<ProductResponse> getProducts() {
//        return null;
//    }


    public List<ProductResponse> getProductsBy(ProductsSearchRequest request) {
        List<Product> products = productService.getProducts(request);
        List<ProductResponse> productResponse = productMapper.toProductResponse(products);
        for (ProductResponse product : productResponse) {
            boolean favoriteExists = favoriteService.favoriteExistsBy(request.getBuyerId(), product.getProductId());
            product.setIsInFavourites(favoriteExists);
        }
        return productResponse;
    }
}
