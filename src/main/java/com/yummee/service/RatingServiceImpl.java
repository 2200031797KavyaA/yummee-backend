package com.yummee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummee.entity.Rating;
import com.yummee.entity.Recipe;
import com.yummee.entity.User;
import com.yummee.repository.RatingRepository;
import com.yummee.repository.RecipeRepository;
import com.yummee.repository.UserRepository;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Rating rateRecipe(Long userId, Long recipeId, Rating rating) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Recipe> recipeOpt = recipeRepository.findById(recipeId);

        if (userOpt.isPresent() && recipeOpt.isPresent()) {
            rating.setUser(userOpt.get());
            rating.setRecipe(recipeOpt.get());
            return ratingRepository.save(rating);
        }
        return null;
    }

    @Override
    public List<Rating> getRatingsByRecipeId(Long recipeId) {
        return ratingRepository.findByRecipeId(recipeId);
    }

    @Override
    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public Double getAverageRatingForRecipe(Long recipeId) {
        List<Rating> ratings = ratingRepository.findByRecipeId(recipeId);
        if (ratings.isEmpty()) return 0.0;

        double total = ratings.stream().mapToDouble(Rating::getStars).sum();
        return total / ratings.size();
    }

    @Override
    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }
}