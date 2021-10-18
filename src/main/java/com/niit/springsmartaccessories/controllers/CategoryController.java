package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.CategoryDto;
import com.niit.springsmartaccessories.models.Category;
import com.niit.springsmartaccessories.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public void createCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
    }
}
