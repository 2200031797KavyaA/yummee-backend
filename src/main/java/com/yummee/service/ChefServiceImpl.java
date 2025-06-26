package com.yummee.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public Chef uploadChefImage(Long chefId, MultipartFile file) throws IOException {
		Chef chef = chefRepository.findById(chefId).orElseThrow(() -> new RuntimeException("Chef not found"));

	    String filename = UUID.randomUUID().toString() + "_" + StringUtils.cleanPath(file.getOriginalFilename());
	    String uploadDir = new File("src/main/resources/static/uploads").getAbsolutePath();
	    File destination = new File(uploadDir + File.separator + filename);
	    file.transferTo(destination);

	    chef.setProfileImageUrl("/uploads/" + filename);
	    return chefRepository.save(chef);
	}
}