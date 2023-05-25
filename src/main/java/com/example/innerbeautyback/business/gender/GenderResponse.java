package com.example.innerbeautyback.business.gender;

import com.example.innerbeautyback.domain.product.gender.Gender;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Gender} entity
 */
@Data
public class GenderResponse implements Serializable {
    private final Integer genderId;
    private final String genderName;
}