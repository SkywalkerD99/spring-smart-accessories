package com.niit.springsmartaccessories.services;

import com.niit.springsmartaccessories.models.Category;
import com.niit.springsmartaccessories.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) { categoryRepository.save(category); }
}
