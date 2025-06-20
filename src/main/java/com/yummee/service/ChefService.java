package com.yummee.service;

import java.util.List;

import com.yummee.entity.Chef;
import com.yummee.entity.Recipe;

public interface ChefService {
	
	Chef saveChef(Chef chef);
    Chef getChefById(Long id);
    List<Chef> getAllChefs();
    List<Recipe> getAllRecipesByChef(Long chefId);  // optional, cross-related
    void deleteChefById(Long id);
}