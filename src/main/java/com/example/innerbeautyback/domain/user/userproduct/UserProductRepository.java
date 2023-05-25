package com.example.innerbeautyback.domain.user.userproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserProductRepository extends JpaRepository<UserProduct, Integer> {

    @Query("select p from UserProduct p where p.id = ?1")
    UserProduct getProductBy(Integer productId);


}