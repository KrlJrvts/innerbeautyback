package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Product} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse implements Serializable {
    private Integer productId;
    private Integer productAge;
    private String productDescription;
    private LocalDate productAvailableAt;
    private Integer productPrice;
    private String countryName;
    private Integer countryId;
    private String genderName;
    private String bloodgroupType;
    private String imageData;
    private Boolean isInFavourites;
}