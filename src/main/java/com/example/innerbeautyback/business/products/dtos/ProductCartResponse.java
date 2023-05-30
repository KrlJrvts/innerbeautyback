package com.example.innerbeautyback.business.products.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ProductCartResponse {
    private Integer totalPrice;
    private List<ProductCart> products;
}
