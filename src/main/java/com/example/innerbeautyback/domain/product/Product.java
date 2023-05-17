package com.example.innerbeautyback.domain.product;

import com.example.innerbeautyback.domain.image.Image;
import com.example.innerbeautyback.domain.product.bloodtype.Bloodtype;
import com.example.innerbeautyback.domain.product.category.Category;
import com.example.innerbeautyback.domain.product.country.Country;
import com.example.innerbeautyback.domain.product.gender.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @NotNull
    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @NotNull
    @Column(name = "available_at", nullable = false)
    private LocalDate availableAt;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bloodtype_id", nullable = false)
    private Bloodtype bloodtype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

}