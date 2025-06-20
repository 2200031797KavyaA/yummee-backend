package com.yummee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummee.entity.Chef;
import com.yummee.entity.Recipe;
import com.yummee.repository.ChefRepository;
import com.yummee.repository.RecipeRepository;

@Service
public class ChefServiceImpl implements ChefService{

	@Autowired
    private ChefRepository chefRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Chef saveChef(Chef chef) {
        return chefRepository.save(chef);
    }

    @Override
    public Chef getChefById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chef> getAllChefs() {
        return chefRepository.findAll();
    }

    @Override
    public List<Recipe> getAllRecipesByChef(Long chefId) {
        return recipeRepository.findByChefId(chefId); // Uses chef_id in recipe table
    }

    @Override
    public void deleteChefById(Long id) {
        chefRepository.deleteById(id);
    }
}