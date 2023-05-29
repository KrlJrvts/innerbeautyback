package com.example.innerbeautyback.domain.user.favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {


    @Query("select f from Favorite f where f.id = ?1")
    Favorite getProductBy(Integer productId);




    @Query("select (count(f) > 0) from Favorite f where f.buyer.id = ?1 and f.product.id = ?2")
    boolean favoriteExistsBy(Integer buyerId, Integer productId);



}