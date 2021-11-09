package com.niit.springsmartaccessories.controllers;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class TestController {

    @GetMapping("/hello")
    public ModelAndView HelloWorld() {
        ModelAndView mdv = new ModelAndView("HelloWorld");
        MultipartFile file = null;
        mdv.addObject("file", file);
        return mdv;
    }

}
