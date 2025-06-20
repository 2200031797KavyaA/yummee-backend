package com.yummee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummee.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long>{
	
	List<Rating> findByRecipeId(Long recipeId);
    List<Rating> findByUserId(Long userId);
    
}