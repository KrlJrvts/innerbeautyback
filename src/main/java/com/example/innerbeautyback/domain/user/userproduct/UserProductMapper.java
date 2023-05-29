package com.example.innerbeautyback.domain.user.userproduct;

import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.business.products.Dtos.ProductCartResponse;
import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.util.ImageUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserProductMapper {

    @Mapping(source = "product.category.name", target = "productName")
    @Mapping(source = "product.image", target = "imageData" ,qualifiedByName = "imageToImageData")
    @Mapping(source = "product.description", target = "productDescription")
    @Mapping(source = "product.age", target = "productAge")
    @Mapping(source = "seller.email", target = "sellerEmail")
    @Mapping(source = "product.country.name", target = "countryName")
    @Mapping(source = "product.bloodgroup.type", target = "bloodgroupType")
    @Mapping(source = "product.price", target = "productPrice")
    @Mapping(source = "product.gender.name", target = "genderName")
    @Mapping(source = "product.availableAt", target = "productAvailableAt")
    ProductCartResponse toProductCartResponse(UserProduct userProduct);
    List<ProductCartResponse> toProductCartResponses(List<UserProduct> userProducts);

    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }
}