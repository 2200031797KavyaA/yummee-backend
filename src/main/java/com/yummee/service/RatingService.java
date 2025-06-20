package com.yummee.service;

import java.util.List;

import com.yummee.entity.Rating;

public interface RatingService {
	
	Rating rateRecipe(Long userId, Long recipeId, Rating rating);
    List<Rating> getRatingsByRecipeId(Long recipeId);
    List<Rating> getRatingsByUserId(Long userId);
    Double getAverageRatingForRecipe(Long recipeId);
    void deleteRating(Long ratingId);
}