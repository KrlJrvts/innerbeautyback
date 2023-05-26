package com.example.innerbeautyback.domain.user.userproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProductRepository extends JpaRepository<UserProduct, Integer> {

    @Query("select p from UserProduct p where p.id = ?1")
    UserProduct getProductBy(Integer productId);

    @Query("select u from UserProduct u where u.buyer.id = ?1 and u.product.id = ?2")
    List<UserProduct> findCartBy(Integer buyerId);

    @Query("select u from UserProduct u where u.buyer.id = ?1")
    List<UserProduct> findAllBy(Integer buyerId);





}