package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.CategoryDto;
import com.niit.springsmartaccessories.exceptions.FileUploadException;
import com.niit.springsmartaccessories.services.CategoryService;
import com.niit.springsmartaccessories.services.StorageServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    private final StorageServiceImpl storageService;
    private final CategoryService categoryService;

    public CategoryController(StorageServiceImpl storageService, CategoryService categoryService) {
        this.storageService = storageService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createCategory(CategoryDto categoryDto, @RequestParam("file") MultipartFile file) {
        try {
            storageService.save(file);
        } catch (FileUploadException e) {
            e.getMessage();
        }
        categoryService.save(categoryDto, file);
    }
}
