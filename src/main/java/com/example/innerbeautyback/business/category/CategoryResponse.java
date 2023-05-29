package com.example.innerbeautyback.business.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse implements Serializable {
    private Integer categoryId;
    private String categoryName;
}