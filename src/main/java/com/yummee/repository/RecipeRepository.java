package com.yummee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummee.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	
	List<Recipe> findByChefId(Long chefId);
	
}