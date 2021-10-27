package com.niit.springsmartaccessories.services;

import com.niit.springsmartaccessories.dto.ProductDto;
import com.niit.springsmartaccessories.exceptions.CategoryNotFoundException;
import com.niit.springsmartaccessories.mapper.ProductMapper;
import com.niit.springsmartaccessories.models.Category;
import com.niit.springsmartaccessories.models.Product;
import com.niit.springsmartaccessories.repositories.CategoryRepository;
import com.niit.springsmartaccessories.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    public void save(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(productDto.getCategoryId().toString()));
        Product product = productMapper.map(productDto, category);
        productRepository.save(product);
    }

    public Product getProduct(long id) {
        return productRepository.getById(id);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
