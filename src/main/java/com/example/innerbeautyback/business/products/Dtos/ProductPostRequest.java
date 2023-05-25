package com.example.innerbeautyback.business.products.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPostRequest {
    private Integer productSellerId;
    private Integer productCategoryId;
    private Integer productCountryId;
    private Integer productBloodgroupId;
    private Integer productGenderId;
    private Integer productAge;
    private String productDescription;
    private LocalDate productAvailableAt;
    private Integer productPrice;
    private String productImage;
}
