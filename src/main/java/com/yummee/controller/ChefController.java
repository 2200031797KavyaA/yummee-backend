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

import com.yummee.entity.Chef;
import com.yummee.entity.Recipe;
import com.yummee.service.ChefService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/chefs")
public class ChefController {
	
	@Autowired
    private ChefService chefService;

    @PostMapping
    public Chef saveChef(@RequestBody Chef chef) {
        return chefService.saveChef(chef);
    }

    @GetMapping("/{id}")
    public Chef getChefById(@PathVariable Long id) {
        return chefService.getChefById(id);
    }

    @GetMapping
    public List<Chef> getAllChefs() {
        return chefService.getAllChefs();
    }

    @GetMapping("/{id}/recipes")
    public List<Recipe> getAllRecipesByChef(@PathVariable Long id) {
        return chefService.getAllRecipesByChef(id);
    }

    @DeleteMapping("/{id}")
    public void deleteChefById(@PathVariable Long id) {
        chefService.deleteChefById(id);
    }
}