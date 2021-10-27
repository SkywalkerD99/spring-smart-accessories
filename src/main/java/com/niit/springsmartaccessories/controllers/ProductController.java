package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.ProductDto;
import com.niit.springsmartaccessories.models.Product;
import com.niit.springsmartaccessories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RolesAllowed("ADMIN")
    @PostMapping("/create")
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @RolesAllowed("ADMIN")
    @PostMapping("/edit")
    public void editProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/{id}")
    public String getProduct(@PathVariable long id) {
        return productService.getProduct(id).toString();
    }


}
