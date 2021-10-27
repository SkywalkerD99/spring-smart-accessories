package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.CategoryDto;
import com.niit.springsmartaccessories.models.Category;
import com.niit.springsmartaccessories.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createCategory(CategoryDto categoryDto) {
        categoryService.save(categoryDto);
    }
}
