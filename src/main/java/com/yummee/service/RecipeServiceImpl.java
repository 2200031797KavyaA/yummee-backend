package com.yummee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummee.entity.Chef;
import com.yummee.entity.Recipe;
import com.yummee.repository.ChefRepository;
import com.yummee.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ChefRepository chefRepository;

    @Override
    public Recipe addRecipe(Recipe recipe) {
        // If a new recipe comes with chef already attached, great. Else we should validate chef.
        if (recipe.getChef() != null) {
            Long chefId = recipe.getChef().getId();
            Optional<Chef> chefOpt = chefRepository.findById(chefId);
            if (chefOpt.isPresent()) {
                recipe.setChef(chefOpt.get());
                return recipeRepository.save(recipe);
            }
        }
        return null;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> getRecipesByChefId(Long chefId) {
        return recipeRepository.findByChefId(chefId);
    }

    @Override
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }
}