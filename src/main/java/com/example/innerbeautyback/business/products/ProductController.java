package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.business.category.CategoriesService;
import com.example.innerbeautyback.business.category.CategoryRequest;
import com.example.innerbeautyback.business.login.LoginResponse;
import com.example.innerbeautyback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Resource
    private ProductService productService;
    @Resource
    private CategoriesService categoriesService;


    @GetMapping("/store")
    @Operation(
            summary = "Returns all Product category names to storeView",
            description = " Returns product category names to storeView which shall be put under Product Category picture")
    public List<CategoryRequest> getCategories() {
        return categoriesService.getCategories();
    }


//    @GetMapping("/store/products")
//    @Operation(
//            summary = "...",
//            description = " Returns product info with ...")
//    public List<ProductDto> getProducts() {
//        List<ProductDto> product = productService.getProducts();
//        return product;
//    }
    @GetMapping("/store/products")
    @Operation(summary = "Returns products requested by categoryId",
            description = """
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Requested Category not found", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ProductResponse> getProductsBy(@RequestParam Integer categoryId) {
        return productService.getProductsBy(categoryId);

    }
}