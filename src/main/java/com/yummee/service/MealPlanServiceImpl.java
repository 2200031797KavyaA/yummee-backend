package com.yummee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummee.entity.MealPlan;
import com.yummee.entity.User;
import com.yummee.repository.MealPlanRepository;
import com.yummee.repository.UserRepository;

@Service
public class MealPlanServiceImpl implements MealPlanService{

	@Autowired
    private MealPlanRepository mealPlanRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public MealPlan createMealPlan(Long userId, MealPlan mealPlan) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            mealPlan.setUser(user);
            return mealPlanRepository.save(mealPlan);
        }
        return null;
    }

    @Override
    public List<MealPlan> getMealPlansByUser(Long userId) {
        return mealPlanRepository.findByUserId(userId);
    }

    @Override
    public MealPlan getMealPlanById(Long planId) {
        return mealPlanRepository.findById(planId).orElse(null);
    }

    @Override
    public void updateMealPlan(Long planId, MealPlan updatedMealPlan) {
        Optional<MealPlan> existing = mealPlanRepository.findById(planId);
        if (existing.isPresent()) {
            MealPlan mealPlan = existing.get();
            mealPlan.setName(updatedMealPlan.getName());
            mealPlan.setRecipes(updatedMealPlan.getRecipes());
            mealPlanRepository.save(mealPlan);
        }
    }

    @Override
    public void deleteMealPlan(Long planId) {
        mealPlanRepository.deleteById(planId);
    }
}