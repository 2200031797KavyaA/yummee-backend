package com.yummee.service;

import java.util.List;

import com.yummee.entity.Recipe;

public interface RecipeService {
	
	Recipe addRecipe(Recipe recipe);
    Recipe getRecipeById(Long id);
    List<Recipe> getAllRecipes();
    List<Recipe> getRecipesByChefId(Long chefId);
    void deleteRecipeById(Long id);
}