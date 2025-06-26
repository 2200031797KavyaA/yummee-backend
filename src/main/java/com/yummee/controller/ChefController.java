package com.yummee.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/upload-image/{chefId}")
    public Chef uploadProfileImage(@PathVariable Long chefId, @RequestParam("image") MultipartFile file) throws IOException {
        return chefService.uploadChefImage(chefId, file);
    }
    
    @PostMapping("/upload")
    public Chef saveChefWithImage(
            @RequestPart("chef") Chef chef,
            @RequestPart("image") MultipartFile imageFile) throws IOException {

        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        String uploadDir = "uploads/chefs/";
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) uploadPath.mkdirs();

        String filePath = uploadDir + fileName;
        imageFile.transferTo(new File(filePath));

        chef.setProfileImageUrl("/images/chefs/" + fileName);

        return chefService.saveChef(chef);
    }
}
