package com.example.innerbeautyback.domain.user.favorite;

import com.example.innerbeautyback.domain.user.userproduct.UserProduct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    @Resource
    private FavoriteRepository favoriteRepository;

    public void validateFavoriteBy(Integer buyerId, Integer productId) {
        boolean favoriteExists = favoriteRepository.favoriteExistsBy(buyerId, productId);
        if (favoriteExists) {
            throw new RuntimeException("Product already in favorites");
        }
    }

    public Favorite getProductBy(Integer productId) {
        return favoriteRepository.getProductBy(productId);
    }

    public boolean favoriteExistsBy(Integer buyerId, Integer productId) {
        return favoriteRepository.favoriteExistsBy(buyerId, productId);
    }

    public void addFavorite(Favorite favorite) {
        favoriteRepository.save(favorite);
    }
}
