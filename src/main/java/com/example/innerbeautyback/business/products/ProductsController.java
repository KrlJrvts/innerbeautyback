package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.business.category.CategoriesService;
import com.example.innerbeautyback.business.category.CategoryResponse;
import com.example.innerbeautyback.business.products.dtos.*;
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
@RequestMapping("/products")
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @Resource
    private CategoriesService categoriesService;

    @Resource
    private FavoriteService favoriteService;

    @GetMapping("/categories")
    @Operation(
            summary = "Returns all Product category names to storeView",
            description = " Returns product category names to storeView which shall be put under Product Category picture")
    public List<CategoryResponse> getCategories() {
        return categoriesService.getCategories();
    }

    @PostMapping("/category-all")
    @Operation(summary = "Returns products requested by categoryId,countryId and bloodgroupId, ",
            description = "When countryId and bloodgroupId is not chosen (0) then all products are listed ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Requested Category not found", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ProductResponse> getProductsBy(@RequestBody ProductsSearchRequest productsSearchRequest) {
        return productsService.getProductsBy(productsSearchRequest);
    }

    @PostMapping("/add")
    @Operation(summary = "Add product to store",
            description = """
                    Product is added to database based on categoryId, countryId, bloodgroupId, genderId,
                    Integer age, string productDate, string productDecription, integer productPrice and string productImage """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")})
    public void addProduct(@RequestBody ProductPostRequest productPostRequest) {
        productsService.addProduct(productPostRequest);
    }

    @PatchMapping("/cart-add")
    @Operation(summary = "Add product to cart",
            description = "Product is added to cart based on productId, buyerId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product added to a cart"),
            @ApiResponse(responseCode = "403", description = "Requested Product not found", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addProductToCart(@RequestParam Integer buyerId, @RequestParam Integer productId) {
        productsService.addProductToCart(productId, buyerId);
    }

    @GetMapping("/cart")
    @Operation(summary = "Returns products in cart",
            description = """
                    Products in cart are returned based on buyerId and there will be displayed categoryName, countryName, bloodgroupName, 
                     genderName, age, productDate, productDescription, productPrice, productImage,""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "You have products in cart"),
            @ApiResponse(responseCode = "403", description = "No products in cart")})
    public ProductCartResponse findAllProductsInCart(@RequestParam Integer buyerId) {
        return productsService.getAllProductsInCart(buyerId);
    }

    @PatchMapping("/cart-buy")
    @Operation(summary = "Delete products from cart",
            description = "Product is deleted from cart based on productId and buyerId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted from cart"),
            @ApiResponse(responseCode = "403", description = "Requested Product not found")})
    public void buyAllProductsFromCart(@RequestParam Integer buyerId) {
        productsService.buyAllProductsFromCart(buyerId);
    }

    @PatchMapping("/cart-remove")
    @Operation(summary = "Remove product from cart",
            description = "Product is removed from cart based on productId and buyerId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product removed from cart"),
            @ApiResponse(responseCode = "403", description = "Requested Product not found")})
    public void removeProductFromCart(@RequestParam Integer buyerId, @RequestParam Integer productId) {
        productsService.removeProductFromCart(buyerId, productId);
    }

    @PatchMapping("/favorite-add")
    @Operation(summary = "Add product to favorite",
            description = """
                    Product is added to favorite based on productId and buyerId.
                    When product is already in user favorite list error 211 is returned""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product added to favorite"),
            @ApiResponse(responseCode = "403", description = "Requested Product not found")})
    public void addProductToFavorite(@RequestParam Integer buyerId, @RequestParam Integer productId) {
        productsService.addOrRemoveProductFromFavorite(buyerId, productId);
    }

    @GetMapping("/favorite")
    @Operation(summary = "Returns products in favorite",
            description = """
                    Products in favorite are returned based on buyerId and there will be displayed categoryName, countryName, bloodgroupName, 
                     genderName, age, productDate, productDescription, productPrice, productImage,""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "You have products in favorite"),
            @ApiResponse(responseCode = "403", description = "No products in favorite")})
    public List<ProductFavoriteResponse> findAllProductsInFavorite(@RequestParam Integer buyerId) {
        return favoriteService.findAllProductsInFavorite(buyerId);
    }
}