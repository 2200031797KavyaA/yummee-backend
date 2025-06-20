package com.yummee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yummee.entity.MealPlan;
import com.yummee.service.MealPlanService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mealplans")
public class MealPlanController {
	
	@Autowired
    private MealPlanService mealPlanService;

    @PostMapping("/user/{userId}")
    public MealPlan createMealPlan(@PathVariable Long userId, @RequestBody MealPlan mealPlan) {
        return mealPlanService.createMealPlan(userId, mealPlan);
    }

    @GetMapping("/user/{userId}")
    public List<MealPlan> getMealPlansByUser(@PathVariable Long userId) {
        return mealPlanService.getMealPlansByUser(userId);
    }

    @GetMapping("/{planId}")
    public MealPlan getMealPlanById(@PathVariable Long planId) {
        return mealPlanService.getMealPlanById(planId);
    }

    @PutMapping("/{planId}")
    public void updateMealPlan(@PathVariable Long planId, @RequestBody MealPlan updatedMealPlan) {
        mealPlanService.updateMealPlan(planId, updatedMealPlan);
    }

    @DeleteMapping("/{planId}")
    public void deleteMealPlan(@PathVariable Long planId) {
        mealPlanService.deleteMealPlan(planId);
    }
}