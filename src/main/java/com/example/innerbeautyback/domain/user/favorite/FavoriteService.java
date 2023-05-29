package com.example.innerbeautyback.domain.user.favorite;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavoriteService {

    @Resource
    private FavoriteRepository favoriteRepository;

    public boolean isProductInFavorites(Integer buyerId, Integer productId) {
        return favoriteRepository.favoriteExistsBy(buyerId, productId);
    }

    public boolean favoriteExistsBy(Integer buyerId, Integer productId) {
        return favoriteRepository.favoriteExistsBy(buyerId, productId);
    }

    public void addFavorite(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    public Optional<Favorite> findOptionalFavoriteBy(Integer buyerId, Integer productId) {
        return favoriteRepository.findFavoriteBy(buyerId, productId);

    }

    public void deleteFavorite(Favorite favorite) {
        favoriteRepository.delete(favorite);
    }
}
