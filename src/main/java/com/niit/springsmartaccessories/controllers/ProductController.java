package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.ProductDto;
import com.niit.springsmartaccessories.models.Product;
import com.niit.springsmartaccessories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }
}
