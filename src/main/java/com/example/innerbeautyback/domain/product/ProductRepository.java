package com.example.innerbeautyback.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.category.id = ?1 and p.status = ?2")
    List<Product> findProductsBy(Integer id, String status);

}