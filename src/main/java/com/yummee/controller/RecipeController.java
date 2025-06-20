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

import com.yummee.entity.Recipe;
import com.yummee.service.RecipeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
	
	@Autowired
    private RecipeService recipeService;

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/chef/{chefId}")
    public List<Recipe> getRecipesByChefId(@PathVariable Long chefId) {
        return recipeService.getRecipesByChefId(chefId);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeById(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
    }
}