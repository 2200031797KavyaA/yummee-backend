package com.yummee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yummee.entity.Rating;
import com.yummee.service.RatingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ratings")
public class RatingController {
	
	@Autowired
    private RatingService ratingService;

    @PostMapping("/rate/{userId}/{recipeId}")
    public Rating rateRecipe(@PathVariable Long userId,
                             @PathVariable Long recipeId,
                             @RequestBody Rating rating) {
        return ratingService.rateRecipe(userId, recipeId, rating);
    }

    @GetMapping("/recipe/{recipeId}")
    public List<Rating> getRatingsByRecipe(@PathVariable Long recipeId) {
        return ratingService.getRatingsByRecipeId(recipeId);
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getRatingsByUser(@PathVariable Long userId) {
        return ratingService.getRatingsByUserId(userId);
    }

    @GetMapping("/recipe/{recipeId}/average")
    public Double getAverageRating(@PathVariable Long recipeId) {
        return ratingService.getAverageRatingForRecipe(recipeId);
    }

    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
    }
}