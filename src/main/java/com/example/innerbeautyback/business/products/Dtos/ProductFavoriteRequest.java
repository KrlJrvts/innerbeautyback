package com.example.innerbeautyback.business.products.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFavoriteRequest {
    private Integer productId;
    private Integer productSellerId;
    private Integer productBuyerId;

}
