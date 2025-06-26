package com.yummee.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Recipe addRecipeWithImage(
            @RequestPart("recipe") String recipeJson,
            @RequestPart("image") MultipartFile imageFile
    ) throws IOException {

        // Convert the recipe JSON string to a Recipe object
        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(recipeJson, Recipe.class);

        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        String uploadDir = System.getProperty("user.dir") + "/uploads/recipes/";
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) uploadPath.mkdirs();

        String filePath = uploadDir + File.separator + fileName;
        imageFile.transferTo(new File(filePath));

        recipe.setImageUrl("/images/recipes/" + fileName);

        return recipeService.addRecipe(recipe);
    }

}