package com.example.innerbeautyback.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.category.id = ?1 and (p.country.id = ?2 or ?2 = 0) and (p.bloodgroup.id = ?3 or ?3 = 0) and (p.status = 'C' or p.status = 'A')")
    List<Product> findActiveAndInCartProductsBy(Integer categoryId, Integer countryId, Integer bloodgroupId);

    @Query("select p from Product p where p.id = ?1 and p.status = ?2")
    Product getProductBy(Integer productId, String productStatus);




}
