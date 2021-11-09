package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.CategoryDto;
import com.niit.springsmartaccessories.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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
        MultipartFile file = null;
        mav.addObject("productService", productService);
        mav.addObject("categoryDto", categoryDto);
        mav.addObject("file", file);
        return mav;
    }

    @RolesAllowed("USER")
    @RequestMapping("/*")
    public ModelAndView getUser() {
        return new ModelAndView("template/shop");
    }
}
