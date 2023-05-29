package com.example.innerbeautyback.domain.user.userproduct;

import com.example.innerbeautyback.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProductRepository extends JpaRepository<UserProduct, Integer> {

    @Query("select p from UserProduct p where p.id = ?1")
    UserProduct getProductBy(Integer productId);


    @Query("select u from UserProduct u where u.buyer.id = ?1 and u.product.status = ?2")
    List<UserProduct> findAllBy(Integer userId, String productStatus);

    @Query("select u from UserProduct u where u.product.status = ?1")
    List<UserProduct> findAllByStatus(String status);

    @Query("select u from UserProduct u where u.product.status = ?1 and u.buyer.id = ?2")
    List<UserProduct> getProductsInCartBy(String productStatus, Integer buyerId);



}