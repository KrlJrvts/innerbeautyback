package com.example.innerbeautyback.business.category;

import com.example.innerbeautyback.domain.product.category.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Category} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest implements Serializable {
    @Size(max = 50)
    @NotNull
    private String categoryName;
}