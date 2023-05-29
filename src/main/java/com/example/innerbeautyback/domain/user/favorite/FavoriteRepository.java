package com.example.innerbeautyback.domain.user.favorite;

import com.example.innerbeautyback.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {


    @Query("select (count(f) > 0) from Favorite f where f.buyer.id = ?1 and f.product.id = ?2 ")
    boolean favoriteExistsBy(Integer buyerId, Integer productId);

    @Query("select f from Favorite f where f.buyer.id = ?1 and f.product.id = ?2 ")
    Optional<Favorite> findFavoriteBy(Integer buyerId, Integer productId);

    @Query("select f from Favorite f where f.buyer.id = ?1 and f.product.id = ?2 and (f.product.status = 'C' or f.product.status = 'A')")
    Optional<Favorite> findActiveAndInCartFavoriteProductBy(Integer buyerId, Integer productId);







}