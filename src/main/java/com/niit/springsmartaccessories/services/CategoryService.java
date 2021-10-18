package com.niit.springsmartaccessories.services;

import com.niit.springsmartaccessories.dto.CategoryDto;
import com.niit.springsmartaccessories.models.Category;
import com.niit.springsmartaccessories.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(CategoryDto categoryDto) {
        List<Category> categories = categoryRepository.findAll();
        for (Category cat: categories) {
            if (cat.getCategoryName().equals(categoryDto.getName()))
                throw new RuntimeException("Category Already Exists!");
        }
        categoryRepository.save(new Category(categoryDto.getName(), categoryDto.getDescription()));
    }
}
