package com.example.innerbeautyback.domain.user.favorite;

import com.example.innerbeautyback.business.products.Dtos.ProductFavoriteResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    @Resource
    private FavoriteRepository favoriteRepository;

    @Resource
    private FavoriteMapper favoriteMapper;


    public boolean favoriteExistsBy(Integer buyerId, Integer productId) {
        return favoriteRepository.favoriteExistsBy(buyerId, productId);
    }

    public void addFavorite(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    public Optional<Favorite> findOptionalFavoriteBy(Integer buyerId, Integer productId) {
        return favoriteRepository.findActiveAndInCartFavoriteProductBy(buyerId, productId);

    }




    public void deleteFavorite(Favorite favorite) {
        favoriteRepository.delete(favorite);
    }

    public List<Favorite> getAllFavoritesBy(Integer buyerId) {
        return favoriteRepository.findAllFavoriteBy(buyerId);
    }

    public List<ProductFavoriteResponse> findAllProductsInFavorite(Integer buyerId) {
        List <Favorite> favorites = favoriteRepository.findAllByBuyerId(buyerId);
        List <ProductFavoriteResponse> productFavoriteResponses = favoriteMapper.toProductFavoriteResponses(favorites);
        return productFavoriteResponses;

    }

}
