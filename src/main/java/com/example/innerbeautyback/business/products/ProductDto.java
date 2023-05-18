package com.example.innerbeautyback.business.products;

import com.example.innerbeautyback.domain.product.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ProductDto implements Serializable {
    private Integer productAge;
    private String productDescription;
    private LocalDate productAvailableAt;
    private Integer productPrice;
    private String productStatus;
    private String categoryName;
    private String countryName;
    private String genderName;
    private String bloodgroupType;
    private String imageData;
}