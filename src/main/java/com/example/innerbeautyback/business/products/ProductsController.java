package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.business.category.CategoriesService;
import com.example.innerbeautyback.business.category.CategoryResponse;
import com.example.innerbeautyback.business.products.Dtos.ProductPostRequest;
import com.example.innerbeautyback.business.products.Dtos.ProductResponse;
import com.example.innerbeautyback.business.products.Dtos.ProductsSearchRequest;
import com.example.innerbeautyback.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Resource
    private ProductsService productsService;
    @Resource
    private CategoriesService categoriesService;


    @GetMapping("/store")
    @Operation(
            summary = "Returns all Product category names to storeView",
            description = " Returns product category names to storeView which shall be put under Product Category picture")
    public List<CategoryResponse> getCategories() {
        return categoriesService.getCategories();
    }


    @PostMapping("/store/products")
    @Operation(summary = "Returns products requested by categoryId,countryId and bloodgroupId, ",
            description = """
                    When countryId and bloodgroupId is not chosen (0) then all products are listed """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Requested Category not found", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ProductResponse> getProductsBy(@RequestBody ProductsSearchRequest productsSearchRequest) {
        return productsService.getProductsBy(productsSearchRequest);

    }


    @PostMapping("/add-item")
    @Operation(summary = "Add product to store",
            description = """
                    Product is added to database based on categoryId, countryId, bloodgroupId, genderId,
                    Integer age, string productDate, string productDecription, integer productPrice and string productImage """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")})
    public void addProduct(@RequestBody ProductPostRequest productPostRequest) {
        productsService.addProduct(productPostRequest);

    }
}