package com.example.innerbeautyback.domain.user.favorite;

import com.example.innerbeautyback.business.products.dtos.ProductFavoriteResponse;
import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.util.ImageUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface FavoriteMapper {

    @Mapping(source = "product.category.name", target = "productName")
    @Mapping(source = "product.age", target = "productAge")
    @Mapping(source = "product.description", target = "productDescription")
    @Mapping(source = "product.price", target = "productPrice")
    @Mapping(source = "product.country.name", target = "countryName")
    @Mapping(source= "product.gender.name", target = "genderName")
    @Mapping(source = "product.bloodgroup.type", target = "bloodgroupType")
    @Mapping(source = "product.image", target = "imageData", qualifiedByName = "imageToImageData")
    @Mapping(source = "product.availableAt", target = "productAvailableAt")
    ProductFavoriteResponse toProductFavoriteResponse(Favorite favorite);
    List<ProductFavoriteResponse> toProductFavoriteResponses(List<Favorite> favorites);


    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }
}
