package com.example.innerbeautyback.business.gender;

import lombok.Data;
import java.io.Serializable;

@Data
public class GenderResponse implements Serializable {
    private final Integer genderId;
    private final String genderName;
}