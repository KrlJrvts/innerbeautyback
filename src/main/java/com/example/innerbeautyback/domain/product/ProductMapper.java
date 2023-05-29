package com.example.innerbeautyback.domain.product;

import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.business.products.dtos.ProductCartResponse;
import com.example.innerbeautyback.business.products.dtos.ProductPostRequest;
import com.example.innerbeautyback.business.products.dtos.ProductResponse;
import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.util.ImageUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface ProductMapper {

    @Mapping(source ="category.name", target = "categoryName")
    @Mapping(source = "id", target = "productId")
    @Mapping(source = "age", target = "productAge")
    @Mapping(source = "description", target = "productDescription")
    @Mapping(source = "availableAt", target = "productAvailableAt")
    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "gender.name", target = "genderName")
    @Mapping(source = "bloodgroup.type", target = "bloodgroupType")
    @Mapping(source = "bloodgroup.id" ,target = "bloodgroupTypeId")
    @Mapping(source = "country.name",target = "countryName")
    @Mapping(source = "country.id",target = "countryId")
    @Mapping(source = "image", target = "imageData",qualifiedByName = "imageToImageData")
    ProductResponse toDto(Product product);

    @Mapping(source ="productAge", target = "age")
    @Mapping(source ="productDescription", target = "description")
    @Mapping(source ="productAvailableAt", target = "availableAt")
    @Mapping(source ="productPrice", target = "price")
    @Mapping(expression ="java(Status.ACTIVE.getLetter())", target = "status")
    @Mapping(source ="productImage", target = "image", qualifiedByName = "imageDataToImage")
    Product toAddProduct(ProductPostRequest productPostRequest);

    ProductCartResponse toProductCartResponse(Product product);
    List <ProductResponse> toProductResponse(List<Product> products);


    @Named("imageDataToImage")
    static Image imageDataToImage(String imageData) {
        if (imageData.isEmpty()) {
            return null;
        }
        return new Image(ImageUtil.base64ImageDataToByteArray(imageData));
    }

    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }
}