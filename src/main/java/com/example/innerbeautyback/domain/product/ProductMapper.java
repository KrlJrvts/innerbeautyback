package com.example.innerbeautyback.domain.product;

import com.example.innerbeautyback.business.products.ProductResponse;
import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.util.ImageUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mapping(source = "age", target = "productAge")
    @Mapping(source = "description", target = "productDescription")
    @Mapping(source = "availableAt", target = "productAvailableAt")
    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "status", target = "productStatus")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "country.name", target = "countryName")
    @Mapping(source = "gender.name", target = "genderName")
    @Mapping(source = "bloodgroup.type", target = "bloodgroupType")
    @Mapping(source = "image", target = "imageData",qualifiedByName = "imageToImageData")
    ProductResponse toDto(Product product);

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

    List<ProductResponse> toProductResponse(List<Product> products);

}