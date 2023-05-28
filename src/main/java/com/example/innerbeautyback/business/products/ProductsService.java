package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.business.bloodgroup.BloodGroupsService;
import com.example.innerbeautyback.business.gender.GenderService;
import com.example.innerbeautyback.business.products.Dtos.ProductCartResponse;
import com.example.innerbeautyback.business.products.Dtos.ProductPostRequest;
import com.example.innerbeautyback.business.products.Dtos.ProductResponse;
import com.example.innerbeautyback.business.products.Dtos.ProductsSearchRequest;
import com.example.innerbeautyback.domain.country.CountryService;
import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.domain.image.ImageService;
import com.example.innerbeautyback.domain.product.Product;
import com.example.innerbeautyback.domain.product.ProductMapper;
import com.example.innerbeautyback.domain.product.ProductService;
import com.example.innerbeautyback.domain.product.category.CategoryService;
import com.example.innerbeautyback.domain.user.UserService;
import com.example.innerbeautyback.domain.user.favorite.FavoriteService;
import com.example.innerbeautyback.domain.user.userproduct.UserProduct;
import com.example.innerbeautyback.domain.user.userproduct.UserProductMapper;
import com.example.innerbeautyback.domain.user.userproduct.UserProductService;
import com.example.innerbeautyback.util.ImageUtil;
import jakarta.annotation.Resource;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Setter
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private FavoriteService favoriteService;

    @Resource
    private ImageService imageService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private CountryService countryService;

    @Resource
    private BloodGroupsService bloodGroupsService;

    @Resource
    private GenderService genderService;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private UserProductMapper userProductMapper;

    @Resource
    private UserService userService;

    @Resource
    private UserProductService userProductService;



    public List<ProductResponse> getProductsBy(ProductsSearchRequest request) {
        List<Product> products = productService.getProducts(request);
        List<ProductResponse> productResponse = productMapper.toProductResponse(products);
        for (ProductResponse product : productResponse) {
            boolean favoriteExists = favoriteService.favoriteExistsBy(request.getBuyerId(), product.getProductId());
            product.setIsInFavourites(favoriteExists);
        }
        return productResponse;
    }

    @Transactional
    public void addProduct(ProductPostRequest productPostRequest) {
        Product product = productMapper.toAddProduct(productPostRequest);

        product.setCategory(categoryService.findById(productPostRequest.getProductCategoryId()));
        product.setCountry(countryService.findById(productPostRequest.getProductCountryId()));
        product.setBloodgroup(bloodGroupsService.findById(productPostRequest.getProductBloodgroupId()));
        product.setGender(genderService.findById(productPostRequest.getProductGenderId()));

        addImageIfPresent(product.getImage());
        productService.addProduct(product);

        UserProduct userProduct = new UserProduct();
        userProduct.setProduct(product);
        userProduct.setSeller(userService.getUserBy(productPostRequest.getProductSellerId()));
        userProductService.addUserProduct(userProduct);


    }

    public void addProductToCart(Integer buyerId, Integer productId) {
        UserProduct userProduct = userProductService.getProductBy(productId);
        userProduct.setBuyer(userService.getUserBy(buyerId));
        userProductService.addUserProduct(userProduct);

    }

    public void addImageIfPresent(Image image) {
        if (ImageUtil.imageIsPresent(image)) {
            imageService.addImage(image);
        }
    }


    public List<ProductCartResponse> getAllProductsInCart(Integer buyerId) {
        List <UserProduct> userProducts = userProductService.getAllProductsInCart(buyerId);
        List<ProductCartResponse> productCartResponses = userProductMapper.toProductCartResponses(userProducts);
        return productCartResponses;
    }
}
