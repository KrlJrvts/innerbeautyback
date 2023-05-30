package com.example.innerbeautyback.business.products.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCart {
    private Integer productId;
    private String productName;
    private Integer productAge;
    private String productDescription;
    private Integer productPrice;
    private String countryName;
    private String genderName;
    private String bloodgroupType;
    private String imageData;
    private String sellerEmail;
    private String productAvailableAt;
}
