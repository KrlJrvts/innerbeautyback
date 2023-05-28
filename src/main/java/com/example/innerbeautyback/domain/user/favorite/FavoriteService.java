package com.example.innerbeautyback.domain.user.favorite;

import com.example.innerbeautyback.domain.user.userproduct.UserProduct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    @Resource
    private FavoriteRepository favoriteRepository;

    public boolean favoriteExistsBy(Integer buyerId, Integer productId) {
       return favoriteRepository.favoriteExistsBy(buyerId, productId);
    }


}
