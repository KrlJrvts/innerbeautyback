package com.example.innerbeautyback.business.products;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsSearchRequest {
    @NotNull
    private Integer buyerId;
    @NotNull
    private Integer categoryId;
    private Integer countryId;
    private Integer bloodgroupId;
}
