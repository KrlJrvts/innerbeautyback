package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.business.category.CategoriesService;
import com.example.innerbeautyback.business.category.CategoryResponse;
import com.example.innerbeautyback.business.products.Dtos.ProductCartResponse;
import com.example.innerbeautyback.business.products.Dtos.ProductPostRequest;
import com.example.innerbeautyback.business.products.Dtos.ProductResponse;
import com.example.innerbeautyback.business.products.Dtos.ProductsSearchRequest;
import com.example.innerbeautyback.domain.user.favorite.FavoriteService;
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

    @Resource
    private FavoriteService favoriteService;


    @GetMapping("/products/categories")
    @Operation(
            summary = "Returns all Product category names to storeView",
            description = " Returns product category names to storeView which shall be put under Product Category picture")
    public List<CategoryResponse> getCategories() {
        return categoriesService.getCategories();
    }


    @PostMapping("/products/category-all")
    @Operation(summary = "Returns products requested by categoryId,countryId and bloodgroupId, ",
            description = """
                    When countryId and bloodgroupId is not chosen (0) then all products are listed """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Requested Category not found", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ProductResponse> getProductsBy(@RequestBody ProductsSearchRequest productsSearchRequest) {
        return productsService.getProductsBy(productsSearchRequest);

    }


    @PostMapping("/products/add")
    @Operation(summary = "Add product to store",
            description = """
                    Product is added to database based on categoryId, countryId, bloodgroupId, genderId,
                    Integer age, string productDate, string productDecription, integer productPrice and string productImage """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")})
    public void addProduct(@RequestBody ProductPostRequest productPostRequest) {
        productsService.addProduct(productPostRequest);

    }


    // create patch function here

    @PatchMapping("/products/cart-add")
    @Operation(summary = "Add product to cart",
            description = """
                    Product is added to cart based on productId, buyerId""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product added to a cart"),
            @ApiResponse(responseCode = "403", description = "Requested Product not found", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addProductToCart(@RequestParam Integer buyerId, @RequestParam Integer productId) {
        productsService.addProductToCart(buyerId, productId);
    }

    @GetMapping("/products/cart")
    @Operation(summary = "Returns products in cart",
            description = """
                    Products in cart are returned based on buyerId and there will be displayed categoryName, countryName, bloodgroupName, 
                     genderName, age, productDate, productDescription, productPrice, productImage,""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "You have products in cart"),
            @ApiResponse(responseCode = "403", description = "No products in cart")})
    public List<ProductCartResponse> findAllProductsInCart(@RequestParam Integer buyerId) {
        List <ProductCartResponse> cartItems = productsService.getAllProductsInCart(buyerId);
        return cartItems;
    }

    @DeleteMapping("/products/cart-delete")
    @Operation(summary = "Delete products from cart",
            description = """
                    Product is deleted from cart based on productId and buyerId""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted from cart"),
            @ApiResponse(responseCode = "403", description = "Requested Product not found")})
    public void deleteProductFromCart(@RequestParam Integer buyerId) {
        productsService.deleteProductFromCart(buyerId);
    }

    @PatchMapping("/products/cart-remove")
    @Operation(summary = "Remove product from cart",
            description = """
                    Product is removed from cart based on productId and buyerId""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product removed from cart"),
            @ApiResponse(responseCode = "403", description = "Requested Product not found")})
    public void removeProductFromCart(@RequestParam Integer buyerId, @RequestParam Integer productId) {
        productsService.removeProductFromCart(buyerId, productId);
    }



}