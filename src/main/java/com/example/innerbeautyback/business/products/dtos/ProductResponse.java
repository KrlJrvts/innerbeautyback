package com.example.innerbeautyback.business.products.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse implements Serializable {
    private String categoryName;
    private Integer productId;
    private Integer productAge;
    private String productDescription;
    private LocalDate productAvailableAt;
    private Integer productPrice;
    private String countryName;
    private Integer countryId;
    private String genderName;
    private String bloodgroupType;
    private Integer bloodgroupTypeId;
    private String imageData;
    private Boolean isInFavourites;
    private String status;
}