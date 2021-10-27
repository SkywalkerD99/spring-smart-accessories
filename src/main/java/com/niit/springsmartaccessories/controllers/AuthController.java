package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.CategoryDto;
import com.niit.springsmartaccessories.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@RestController
public class AuthController {

    private final ProductService productService;

    public AuthController(ProductService productService) {
        this.productService = productService;
    }

    @RolesAllowed("ADMIN")
    @RequestMapping("/admin")
    public ModelAndView getAdmin() {
        ModelAndView mav = new ModelAndView("admin/index");
        CategoryDto categoryDto = new CategoryDto();
        mav.addObject("productService", productService);
        mav.addObject("categoryDto", categoryDto);
        return mav;
    }

    @RolesAllowed("USER")
    @RequestMapping("/*")
    public String getUser() {
        return "template/shop";
    }
}
