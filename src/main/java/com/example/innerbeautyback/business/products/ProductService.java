package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.domain.product.Product;
import com.example.innerbeautyback.domain.product.ProductMapper;
import com.example.innerbeautyback.domain.product.ProductsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductsService productsService;

    @Resource
    private ProductMapper productMapper;

//    public List<ProductResponse> getProducts() {
//        return null;
//    }

    public List<ProductResponse> getProductsBy(Integer categoryId, Integer countryId, Integer bloodgroupId) {
        List<Product> products = productsService.findProductsBy(categoryId,countryId, bloodgroupId);
        List<ProductResponse> productResponse = productMapper.toProductResponse(products);

        return productResponse;
    }
}
