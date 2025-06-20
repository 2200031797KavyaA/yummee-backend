package com.yummee.service;

import java.util.List;

import com.yummee.entity.MealPlan;

public interface MealPlanService {
	
	MealPlan createMealPlan(Long userId, MealPlan mealPlan);
    List<MealPlan> getMealPlansByUser(Long userId);
    MealPlan getMealPlanById(Long planId);
    void updateMealPlan(Long planId, MealPlan updatedMealPlan);
    void deleteMealPlan(Long planId);
}